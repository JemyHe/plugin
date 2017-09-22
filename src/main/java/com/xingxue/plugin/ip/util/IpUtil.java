package com.xingxue.plugin.ip.util;

import com.alibaba.fastjson.JSON;
import com.xingxue.plugin.ip.entity.IpInfo;
import com.xingxue.plugin.ip.entity.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Created by Administrator on 2017/9/21.
 *  模拟业务：
 *  用户在前台发送登录请求，登录成功后：
 *  1.将request中的客户端ip地址取出
 *  2.将ip地址作为参数访问第三方接口
 *  3.将josn结果反序列化为对应实体类
 *  注:如果单纯测试第三方接口，可以直接跳过第一步
 */
public class IpUtil {

    //取到最近的路由http实例
    private static CloseableHttpClient client = HttpClients.createDefault();

    //第三方接口地址
    private static String baseUrl = "http://ip.taobao.com/service/getIpInfo.php?ip=";

    /**
     * 通过request拿到ip地址对应的地区信息
     * @param request
     * @return
     */
    public static void getArea(HttpServletRequest request) {
        //从request中取出客户端ip地址
        String ip = getRemoteIp(request);
        //第三方接口取到json数据
        String ipResp = getIpInfo(ip);
        //JSON的反序列化
        Response response = JSON.parseObject(ipResp, Response.class);
        if (response.getCode() != 0) {
           //请求失败，应当返回默认地址
        }
        IpInfo info = response.getData();
        //本网站的业务只在中国开放
        if (!Objects.equals("中国", info.getCountry())) {
            //非中国地区应该返回默认地址
        }
        //在数据库中查询对应的地区信息

    }

    /**
     *  将request中的客户端ip地址取出
     * @param request
     * @return
     */
    private static String getRemoteIp(HttpServletRequest request) {
        //x-forwarded-for:代表客户端，也就是HTTP的请求端真实的IP，只有在通过了HTTP代理或者负载均衡服务器时才会添加该项
        String ip = request.getHeader("x-forwarded-for");
        //Proxy-Client-IP和WL-Proxy-Client-IP: 只有在Apache（Weblogic Plug-In Enable）+WebLogic搭配下出现，其中“WL”就是WebLogic的缩写
        //访问路径是:Client -> Apache WebServer + Weblogic http plugin -> Weblogic Instances
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        //0:0:0:0:0:0:0:1: IPV6的形式,win7下可能会出现
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    /**
     * 调用淘宝第三方接口，查询ip地址对应地区
     * @param ip
     * @return
     */
    public static String getIpInfo(String ip) {
        HttpGet httpGet = new HttpGet(baseUrl + ip);
        try {
            HttpResponse response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //取出json数据
                HttpEntity entity = response.getEntity();
                //十六进制字符串转换为中文UTF-8
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));
                String tmp;
                String content = "";
                while((tmp = reader.readLine()) != null) {
                    content += tmp+"\r\n";
                }
                return content;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
