/*
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

*/
/**
 * Created by Administrator on 2017/9/19.
 *//*

public class SendMailService {

    private final static String host = "smtp.qq.com"; //qq邮箱的服务器
    private final static String formName = "1277417298@qq.com";//你的邮箱
    private final static String password = ".................."; //授权码
    private final static String replayAddress = "1277417298@qq.com"; //你的邮箱

    */
/**
     * 发送html文本信息
     * @param mail
     * @throws Exception
     *//*

    public static void sendHtmlMail(Mail mail) throws Exception {
            mail.setHost(host);
            mail.setFormName(formName);
            mail.setFormPassword(password);
            mail.setReplayAddress(replayAddress);

            Message message = getMessage(mail);
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            BodyPart htmlPart = new MimeBodyPart();
            // 设置HTML内容
            String contentData = "";
            System.out.println(mail.getInsufficient().size() == mail.getAdvice().size() && mail.getAdvice().size() == mail.getOpinion().size());
            if (mail.getInsufficient().size() == mail.getAdvice().size() && mail.getAdvice().size() == mail.getOpinion().size()) {
                for (int i = 0; i < mail.getInsufficient().size(); i++) {
                    contentData = contentData + "<tr><td align=\"center\" valign=\"middle\"><p>" + (i + 1) + "</p></td>" +
                            "<td align=\"center\" valign=\"middle\"><p>" + mail.getInsufficient().get(i) + "</p></td>" +
                            "<td align=\"center\" valign=\"middle\"><p>" + mail.getAdvice().get(i) + "</p></td>" +
                            "<td align=\"center\" valign=\"middle\"><p>" + mail.getOpinion().get(i) + "</p></td><tr>";
                }
            }
            htmlPart.setContent("<html>\n" +
                    "<head>\n" +
                    "    <meta charset=\"utf-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <style>\n" +
                    "        p {\n" +
                    "            font-family: \"新宋体\";\n" +
                    "            font-weight: bold;\n" +
                    "            font-size: 20px;\n" +
                    "        }\n" +
                    "    </style>" +
                    "</head>\n" +
                    "<body>" +
                    "<div text-align:center><table border=\"1\" cellspacing=\"0\">\n" +
                    "<tr><td colspan=\"4\" align=\"center\" valign=\"middle\"><img src=\"cid:image\">" + "</td></tr>\n" +
                    "<tr><td align=\"center\" valign=\"middle\"><p>学员</p></td><td width=\"28%\" align=\"center\" valign=\"middle\"><p>上阶段疑惑</p></td><td width=\"28%\" align=\"center\" valign=\"middle\"><p>给老师的建议</p></td><td width=\"28%\"align=\"center\" valign=\"middle\"><p>对老师的意见</p></td></tr>\n" +
                    contentData +
                    "</table></div>" +
                    "</body>\n" +
                    "</html>", "text/html; charset=utf-8");

            mainPart.addBodyPart(htmlPart);

            DataSource fds = new FileDataSource(EchartPicture.echartPicture(mail.getImg()));

            html.setDataHandler(new DataHandler(fds));
            html.setHeader("Content-ID", "<image>");

            mainPart.addBodyPart(html);
            message.setContent(mainPart);

            Transport.send(message);
    }

    */
/*public static void sendTextMail(MailInfo info) throws Exception {

        info.setHost(host);
        info.setFormName(formName);
        info.setFormPassword(password);
        info.setReplayAddress(replayAddress);
        Message message = getMessage(info);
        //消息发送的内容
        message.setText(info.getContent());

        Transport.send(message);
    }*//*


    private static Message getMessage(Mail info) throws Exception {
        final Properties p = System.getProperties();
        p.setProperty("mail.smtp.host", info.getHost());
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.user", info.getFormName());
        p.setProperty("mail.smtp.pass", info.getFormPassword());
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
        message.setSubject(info.getSubject());
        //接受消息的人
        message.setReplyTo(InternetAddress.parse(info.getReplayAddress()));
        //消息的发送者
        message.setFrom(new InternetAddress(p.getProperty("mail.smtp.user"), "日落时的雪"));
        // 创建邮件的接收者地址
        //message.setRecipient(Message.RecipientType.TO,new InternetAddress(info.getToAddress()));

        Address[] address = new InternetAddress[info.getToAddress().length];
        for (int i = 0; i < info.getToAddress().length; i++) {

            address[i] = new InternetAddress(info.getToAddress()[i]);
        }
        message.setRecipients(Message.RecipientType.TO, address);
        //创建邮件的抄送者地址
        System.out.println("----------------------");
        if (info.getCc() != null) {
            if (info.getCc().equals("yes")) {
                message.setRecipient(Message.RecipientType.CC, new InternetAddress("105308360@qq.com"));
            }
        }


        // 消息发送的时间
        message.setSentDate(new Date());
        return message;
    }
}
*/
