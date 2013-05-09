package com.fengjing.framework.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

@SuppressWarnings("serial")
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {

	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken() {
		super();
	}

	public CaptchaUsernamePasswordToken(String username, String password,boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

}
