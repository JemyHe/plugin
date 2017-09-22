package com.xingxue.plugin.oss.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.xingxue.plugin.oss.constants.OssConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.util.Date;

/**
 * Created by 何冠雄 on 2017/9/22.
 */
@Component
public class OSSUtil {

    @Autowired
    private OSSClient aliyunOssClient;

    /**
     * 上传一个字符串
     * @param str
     */
    public void uploadStr(String str,String key){
        aliyunOssClient.putObject(OssConstant.ALIYUN_OSS_BUCKET_NAME, key, new ByteArrayInputStream(str.getBytes()));
        aliyunOssClient.shutdown();
    }

    /**
     * 上传一个bytes数组
     * @param content
     */
    public void uploadBytes(byte[] content,String key){
        aliyunOssClient.putObject(OssConstant.ALIYUN_OSS_BUCKET_NAME, key , new ByteArrayInputStream(content));
        aliyunOssClient.shutdown();
    }

    /**
     * 上传本地文件
     * @param path
     */
    public void uploadFile(String path,String key){
        path="src/main/resources/oss/testFile/钢铁侠.png";
        aliyunOssClient.putObject(OssConstant.ALIYUN_OSS_BUCKET_NAME, key , new File(path));
        aliyunOssClient.shutdown();
    }


    /**
     * 设置存储空间的文件夹
     * @param dirName 文件夹名称
     */
    public void createDir(String dirName){
        dirName = "test-directory/";
        aliyunOssClient.putObject(OssConstant.ALIYUN_OSS_BUCKET_NAME, dirName, new ByteArrayInputStream(new byte[0]));
        // 关闭client
        aliyunOssClient.shutdown();
    }

    /**
     * 下载文件到本地
     * @param
     */
    public void download(){
        aliyunOssClient.getObject(new GetObjectRequest(OssConstant.ALIYUN_OSS_BUCKET_NAME, "str.txt"), new File("src/main/resources/oss/download/download.txt"));
        aliyunOssClient.getObject(new GetObjectRequest(OssConstant.ALIYUN_OSS_BUCKET_NAME, "test.png"), new File("src/main/resources/oss/download/download.png"));
    }

    /**
     * 生成授权访问的url链接
     */
    public void createUrl(String key){
        // 设置URL过期时间为1小时
        Date expiration = new Date(new Date().getTime() + OssConstant.ALIYUN_OSS_EXPIRE);
        // 生成URL
        URL url = aliyunOssClient.generatePresignedUrl(OssConstant.ALIYUN_OSS_BUCKET_NAME, key , expiration);
        String path = url.getProtocol()+"://"+url.getHost()+url.getFile();
        System.out.println(path);
    }

}
