package com.liangzd.verifyCode.phone;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 短信发送工具类
 * @author Administrator
 *
 */
public class PhoneVerifyCode {
	private PhoneConfiguration configuration = null;

    public String sendMsg(String phone) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(configuration.getServerUrl());

        String curTime=String.valueOf((new Date().getTime()/1000L));
        String checkSum=CheckSumBuilder.getCheckSum(configuration.getAppSecret(),configuration.getNonce(),curTime);

        //设置请求的header
        post.addHeader("AppKey",configuration.getAppKey());
        post.addHeader("Nonce",configuration.getNonce());
        post.addHeader("CurTime",curTime);
        post.addHeader("CheckSum",checkSum);
        post.addHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        //设置请求参数
        List<NameValuePair> nameValuePairs =new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("mobile",phone));
        if(configuration.getTemplateid() != null && "".equals(configuration.getTemplateid())) {
        	nameValuePairs.add(new BasicNameValuePair("templateid", configuration.getTemplateid()));
        }
        if(configuration.getCodelen() != null && "".equals(configuration.getCodelen())) {
        	nameValuePairs.add(new BasicNameValuePair("codeLen", configuration.getCodelen()));
        }
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));

        //执行请求
        HttpResponse response=httpclient.execute(post);
        String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");
        return responseEntity;
    }

	public PhoneConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(PhoneConfiguration configuration) {
		this.configuration = configuration;
	}

	public PhoneVerifyCode() {
		super();
	}

	public PhoneVerifyCode(PhoneConfiguration configuration) {
		super();
		this.configuration = configuration;
	}
}