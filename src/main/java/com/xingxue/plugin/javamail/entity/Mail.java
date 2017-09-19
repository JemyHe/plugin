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

    //根据内容不同自定义的属性

    //发送内容不足
    private List<String> insufficient;
    //发送内容建议
    private List<String> advice;
    //发送内容意见
    private List<String> opinion;
    //图片内容
    private String img;
    //附件图片路径
    private String picturePath;

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

    public String[] getToAddress() {
        return toAddress;
    }

    public void setToAddress(String[] toAddress) {
        this.toAddress = toAddress;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getInsufficient() {
        return insufficient;
    }

    public void setInsufficient(List<String> insufficient) {
        this.insufficient = insufficient;
    }

    public List<String> getAdvice() {
        return advice;
    }

    public void setAdvice(List<String> advice) {
        this.advice = advice;
    }

    public List<String> getOpinion() {
        return opinion;
    }

    public void setOpinion(List<String> opinion) {
        this.opinion = opinion;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "host='" + host + '\'' +
                ", formName='" + formName + '\'' +
                ", formPassword='" + formPassword + '\'' +
                ", replayAddress='" + replayAddress + '\'' +
                ", cc='" + cc + '\'' +
                ", toAddress=" + Arrays.toString(toAddress) +
                ", subject='" + subject + '\'' +
                ", insufficient=" + insufficient +
                ", advice=" + advice +
                ", opinion=" + opinion +
                ", img='" + img + '\'' +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}
