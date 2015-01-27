package com.tarena.poll.web.forms;

import org.apache.struts.action.ActionForm;

/**
 * 封装登录所需参数
 * @author liuxiaofei
 *
 */
public class LoginForm extends ActionForm {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 8531980466202057472L;

	/* 用户名 */
	private String loginName;
	 
	/* 密码 */
	private String password;

	/**
	 * @return the name
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param name the name to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the passwd
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}

