package com.tarena.poll.commons.mail;

import java.util.Properties;

/**********************************
 * 发送邮件信息，此类是对邮箱发送服务器的相关信息的一个JAVABEAN
 * @author think-yejf
 *
 */
public class SendMailInfo {

	/** 邮箱发送服务器主机 */
	private String smtp_host;
	
	/** 邮箱发送服务器端口 */
	private String smtp_port;
	
	/** 发件人 */
	private String from;
	
	/** 收件人，因为有可能会有多个 */
	private String[] to;
	
	/** 抄送人 */
	private String[] cc;
	
	/** 暗送人 */
	private String[] bcc;
	
	/** 登录邮箱的身分认证所用: 用户名 */
	private String username;
	
	/** 登录邮箱的身分认证所用: 密码 */
	private String password;
	
	/** 是否要做身份认证 */
	private boolean validate = false;
	
	/** 邮件主题 */
	private String subject = "默认标题";
	
	/** 邮件内容 */
	private String content;
	
	/** 邮件附件文件名 */
	private String[] attachFileName;

	public String getSmtp_host() {
		return smtp_host;
	}

	public void setSmtp_host(String smtp_host) {
		this.smtp_host = smtp_host;
	}

	public String getSmtp_port() {
		return smtp_port;
	}

	public void setSmtp_port(String smtp_port) {
		this.smtp_port = smtp_port;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getAttachFileName() {
		return attachFileName;
	}

	public void setAttachFileName(String[] attachFileName) {
		this.attachFileName = attachFileName;
	}
	
	public Properties getMailSessionProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", this.smtp_host);
		props.put("mail.smtp.port", this.smtp_port);
		props.put("mail.smtp.auth", this.validate ? "true" : "false");
		return props;
	}
	
}



