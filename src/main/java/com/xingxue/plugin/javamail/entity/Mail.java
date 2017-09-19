package com.xingxue.plugin.javamail.entity;


import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
public class Mail {
    //邮箱服务器
    private String host;
    //用户邮箱
    private String formName;
    //用户授权码
    private String formPassword;
    //消息回复邮箱
    private String replayAddress;
    //抄送地址
    private String cc;
    //发送地址
    private String[] toAddress;
    //发送主题
    private String subject;
    //发送内容
    private String content;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormPassword() {
        return formPassword;
    }

    public void setFormPassword(String formPassword) {
        this.formPassword = formPassword;
    }

    public String getReplayAddress() {
        return replayAddress;
    }

    public void setReplayAddress(String replayAddress) {
        this.replayAddress = replayAddress;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String[] getToAddress() {
        return toAddress;
    }

    public void setToAddress(String[] toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
