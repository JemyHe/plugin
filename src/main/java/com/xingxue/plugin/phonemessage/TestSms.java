package com.xingxue.plugin.phonemessage;
/*
* 1.登录注册阿里云
* 2.全部导航---产品---云通信---短信服务
* 3.开通服务
* 4.设置短信签名，短信模板（2小时的审核）
* 5.充值
* 6.获取accesskeys和密码
* 7.加入maven依赖
mvn install:-file -Dfile=C:\aliyun-java-sdk-core-3.2.3.jar -DgroupId=com.aliyun -DartifactId=aliyun-java-sdk-core -Dversion=3.2.3 -Dpackaging=jar
mvn install:install-file -Dfile=C:\aliyun-java-sdk-dysmsapi-1.0.0-SANPSHOT.jar -DgroupId=com.aliyun -DartifactId=aliyun-java-sdk-dysmsapi -Dversion=1.0.0 -Dpackaging=jar
    <dependency>
      <groupId>com.aliyun</groupId>
      <artifactId>aliyun-java-sdk-core</artifactId>
      <version>3.2.3</version>
    </dependency>
    <dependency>
      <groupId>com.aliyun</groupId>
      <artifactId>aliyun-java-sdk-dysmsapi</artifactId>
      <version>1.0.0</version>
    </dependency>
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
