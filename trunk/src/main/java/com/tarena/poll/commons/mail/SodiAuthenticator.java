package com.tarena.poll.commons.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SodiAuthenticator extends Authenticator {

	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;
	
	/** 空参构造 */
	public SodiAuthenticator() {
		
	}
	/**************
	 * 有参构造
	 * @param un
	 * @param pwd
	 */
	public SodiAuthenticator(String un, String pwd) {
		this.username = un;
		this.password = pwd;
	}
	
	/***********
	 * 返回认证信息
	 */
	protected PasswordAuthentication getPasswordAuthentication() {
		
		return new PasswordAuthentication(username,password);
		
	}

	
}
