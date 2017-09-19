package com.xingxue.plugin.javamail.service;

import com.xingxue.plugin.javamail.entity.Mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;


/**
 * Created by Administrator on 2017/6/14.
 */
public class TestHtmlMail {

    public static void send(Mail mail) {

        try {
            //文本邮件
            //MailSendUtil.sendTextMail(info);
            //html邮件
            MailSendUtil.sendHtmlMail(mail);
        } catch (Exception e) {
            System.out.print("邮件发送失败！");
            e.printStackTrace();
        }
    }
}


