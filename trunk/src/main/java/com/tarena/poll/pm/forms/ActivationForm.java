package com.tarena.poll.pm.forms;

import org.apache.struts.action.ActionForm;
/**
 * 激活考评时使用，用来封装class和PM信息
 * @author liuxiaofei & zhengxh 2009_1_6 :16:45
 *
 */
public class ActivationForm extends ActionForm {
	private static final long serialVersionUID = 6998468576395920121L;
	private int className;
	private int realName;
	public int getClassName() {
		return className;
	}
	public void setClassName(int className) {
		this.className = className;
	}
	public int getRealName() {
		return realName;
	}
	public void setRealName(int realName) {
		this.realName = realName;
	}

	
}
