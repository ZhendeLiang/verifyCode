package com.liangzd.verifyCode.phone;

public class PhoneConfiguration {
	//发送验证码的请求路径URL
	private String serverUrl;
	//网易云信分配的账号
    private String appKey;
    //网易云信分配的密钥
    private String appSecret;
    //随机数
    private String nonce;
    //短信模板ID 语音验证码4073043 不填写默认为短信验证码
    private String templateid;
    //验证码长度，范围4～10，默认为4
    private String codelen;
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getTemplateid() {
		return templateid;
	}
	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}
	public String getCodelen() {
		return codelen;
	}
	public void setCodelen(String codelen) {
		this.codelen = codelen;
	}
	public PhoneConfiguration() {
		super();
	}
	public PhoneConfiguration(String serverUrl, String appKey, String appSecret, String nonce) {
		super();
		this.serverUrl = serverUrl;
		this.appKey = appKey;
		this.appSecret = appSecret;
		this.nonce = nonce;
	}
	public PhoneConfiguration(String serverUrl, String appKey, String appSecret, String nonce, String templateid,
			String codelen) {
		super();
		this.serverUrl = serverUrl;
		this.appKey = appKey;
		this.appSecret = appSecret;
		this.nonce = nonce;
		this.templateid = templateid;
		this.codelen = codelen;
	}
}
