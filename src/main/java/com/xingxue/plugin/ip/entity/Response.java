package com.xingxue.plugin.ip.entity;

/**
 * Created by Administrator on 2017/9/21.
 * 对应第三方返回的json数据
 */
public class Response {
    private int code;//状态码，正常为0，异常的时候为非0
    private IpInfo data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public IpInfo getData() {
        return data;
    }

    public void setData(IpInfo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
