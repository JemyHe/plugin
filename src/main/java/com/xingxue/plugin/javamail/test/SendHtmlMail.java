package com.xingxue.plugin.javamail.test;

import com.xingxue.plugin.javamail.entity.Mail;
import com.xingxue.plugin.javamail.service.MailSendUtil;

public class SendHtmlMail {

    public static void main(String[] args) {
        Mail mail = new Mail();
        //设置发件人
        String[] send = {"1277417298@qq.com","1290134546@qq.com"};
        mail.setToAddress(send);
        //设置标题
        mail.setSubject("测试");
        try {
            //html邮件
            MailSendUtil.sendHtmlMail(mail);
        } catch (Exception e) {
            System.out.print("邮件发送失败！");
            e.printStackTrace();
        }
    }
}
