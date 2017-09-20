package com.xingxue.plugin.phonemessage;
/*
* 1.登录注册阿里云
* 2.全部导航---产品---云通信---短信服务
* 3.开通服务
* 4.设置短信签名，短信模板（2小时的审核）
* 5.充值
* 6.获取accesskeys和密码
* */
public class TestSms {

    public static void main(String[] args){
        //发送的手机号
        String phone = "15209181772";
        //验证码
        String code = "6823";
        try{
            SmsUtil.send(phone,code);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
