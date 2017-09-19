package com.xingxue.plugin.javamail.service;
import com.xingxue.plugin.javamail.entity.Mail;

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
public class MailSendUtil {
    private final static String host = "smtp.qq.com"; //qq邮箱的服务器
    private final static String formName = "1277417298@qq.com";//你的邮箱
    private final static String password = "qvockfkanmvpbaef"; //授权码，邮箱--设置--账户-smtp服务开启给的第三方密码
    private final static String replayAddress = "1277417298@qq.com"; //回复邮箱

    public static void sendHtmlMail(Mail mail) throws Exception {
        mail.setHost(host);
        mail.setFormName(formName);
        mail.setFormPassword(password);
        mail.setReplayAddress(replayAddress);
        //获取邮件信息
        Message message = getMessage(mail);
        // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart mainPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart htmlPart = new MimeBodyPart();
        // 设置HTML内容tmlContent
        htmlPart.setContent(HtmlContent.htmlContent, "text/html; charset=utf-8");

        mainPart.addBodyPart(htmlPart);

        message.setContent(mainPart);

        Transport.send(message);
    }
    private static Message getMessage(Mail mail) throws Exception {
        final Properties p = System.getProperties();
        p.setProperty("mail.smtp.host", mail.getHost());
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.user", mail.getFormName());
        p.setProperty("mail.smtp.pass", mail.getFormPassword());
        p.setProperty("mail.smtp.port", "587");

        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session session = Session.getInstance(p, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(p.getProperty("mail.smtp.user"), p.getProperty("mail.smtp.pass"));
            }
        });
        session.setDebug(true);
        Message message = new MimeMessage(session);
        //消息发送的主题
        message.setSubject(mail.getSubject());
        //接受消息的人
        message.setReplyTo(InternetAddress.parse(mail.getReplayAddress()));
        //消息的发送者
        message.setFrom(new InternetAddress(p.getProperty("mail.smtp.user"), "日落时的雪"));
        // 创建邮件的接收者地址
        //message.setRecipient(Message.RecipientType.TO,new InternetAddress(info.getToAddress()));

        Address[] address = new InternetAddress[mail.getToAddress().length];
        for (int i = 0; i < mail.getToAddress().length; i++) {

            address[i] = new InternetAddress(mail.getToAddress()[i]);
        }
        message.setRecipients(Message.RecipientType.TO, address);
        //创建邮件的抄送者地址

        if (mail.getCc() != null) {
            if (mail.getCc().equals("yes")) {
                message.setRecipient(Message.RecipientType.CC, new InternetAddress("105308360@qq.com"));
            }
        }
        // 消息发送的时间
        message.setSentDate(new Date());
        return message;
    }
}
