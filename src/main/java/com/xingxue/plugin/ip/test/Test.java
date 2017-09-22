package com.xingxue.plugin.ip.test;

import com.alibaba.fastjson.JSON;
import com.xingxue.plugin.ip.entity.IpInfo;
import com.xingxue.plugin.ip.entity.Response;
import com.xingxue.plugin.ip.util.IpUtil;

import java.util.Objects;

/**
 * Created by Administrator on 2017/9/21.
 */
public class Test {
    public static void main(String[] args) {
        //ip = "125.76.165.190";
        //ip = "218.25.19.153";
        String ip = "210.75.225.254";
        String ipInfo = IpUtil.getIpInfo(ip);
        //JSON的反序列化
        Response response = JSON.parseObject(ipInfo, Response.class);
        IpInfo info = response.getData();
        System.out.println(response);
        System.out.println(info);
    }
}
