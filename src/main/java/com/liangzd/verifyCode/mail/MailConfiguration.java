package com.liangzd.verifyCode.mail;

public class MailConfiguration {
	// 发件人的账号
	private String userMail;
    // 访问SMTP服务时需要提供的密码 
    private String password;
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MailConfiguration() {
		super();
	}
	public MailConfiguration(String userMail, String password) {
		super();
		this.userMail = userMail;
		this.password = password;
	}
}
