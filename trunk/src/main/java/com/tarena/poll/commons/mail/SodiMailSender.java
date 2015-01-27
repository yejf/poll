package com.tarena.poll.commons.mail;

import java.util.Date;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*****************************
 * 邮件发送者
 * @author think-yejf
 *
 */
public class SodiMailSender {

	/***********************************
	 * 发送纯文本文件
	 * @param smi 邮件发送服务器和发送邮件信息
	 * @return	成功返回 true, 否则返回 false
	 */
	public static boolean sendTextMail(SendMailInfo smi) {
		Authenticator auth = null;	//判断是否要做身份认证
		if(smi.isValidate()) {
			auth = new SodiAuthenticator(smi.getUsername(),smi.getPassword());
		}
		//创建邮件会话
		Session session = Session.getDefaultInstance(smi.getMailSessionProperties(),auth);
		try {
			//创建一个消息
			Message msg = new MimeMessage(session);
			//设置消息相关的信息
			msg.setFrom(new InternetAddress(smi.getFrom()));	//设定发件人
			Address[] to_addresses = convertStringsToAddress(smi.getTo());
			msg.setRecipients(Message.RecipientType.TO, to_addresses);
			
			//如果有存在抄送者，则设定
			Address[] cc_addresses = convertStringsToAddress(smi.getCc());
			if(cc_addresses != null) {
				msg.setRecipients(Message.RecipientType.CC, cc_addresses);
			}
			//如果有存在暗送者，则设定
			Address[] bcc_addresses = convertStringsToAddress(smi.getBcc());
			if(bcc_addresses != null) {
				msg.setRecipients(Message.RecipientType.BCC, bcc_addresses);
			}
			
			//设置主题
			if(smi.getSubject() != null) {
				msg.setSubject(smi.getSubject());
			} 
			//设置内容
			if(smi.getContent() != null) {
				System.out.println(smi.getContent());
				msg.setText(smi.getContent());
			}
			//设置发送时间
			msg.setSentDate(new Date());
			
			//发送邮件
			Transport.send(msg);
			
			return true;
		} catch (MessagingException me) {
			String message = "邮件发送失败，错误原因: \n"+me.getMessage();
			System.out.println(message);
			me.printStackTrace();
			Exception ex = null;  
			if((ex = me.getNextException()) != null) {
				System.out.println(ex.toString());
				ex.printStackTrace();
			}
		}
		
		return false;
	}
	
	/*****************************************
	 * 发送HTML格式邮件
	 * @param smi  邮件发送服务器和发送邮件信息
	 * @return
	 */
	public static boolean sendHtmlMail(SendMailInfo smi) {
		Authenticator auth = null;	//判断是否要做身份认证
		if(smi.isValidate()) {
			auth = new SodiAuthenticator(smi.getUsername(),smi.getPassword());
		}
		//创建邮件会话
		Session session = Session.getDefaultInstance(smi.getMailSessionProperties(),auth);
		try {
			//创建一个消息
			Message msg = new MimeMessage(session);
			//设置消息相关的信息
			msg.setFrom(new InternetAddress(smi.getFrom()));	//设定发件人
			Address[] to_addresses = convertStringsToAddress(smi.getTo());
			msg.setRecipients(Message.RecipientType.TO, to_addresses);
			
			//如果有存在抄送者，则设定
			Address[] cc_addresses = convertStringsToAddress(smi.getCc());
			if(cc_addresses != null) {
				msg.setRecipients(Message.RecipientType.CC, cc_addresses);
			}
			//如果有存在暗送者，则设定
			Address[] bcc_addresses = convertStringsToAddress(smi.getBcc());
			if(bcc_addresses != null) {
				msg.setRecipients(Message.RecipientType.BCC, bcc_addresses);
			}
			
			//设置主题
			if(smi.getSubject() != null) {
				msg.setSubject(smi.getSubject());
			} 
			//设置发送时间
			msg.setSentDate(new Date());
			
			//设置多媒体内容
			Multipart multipart = new MimeMultipart();
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent(smi.getContent(), "text/html;charset=UTF-8");
			multipart.addBodyPart(bodyPart);
			msg.setContent(multipart);
			
			//发送邮件
			Transport.send(msg);
			
			return true;
		} catch (MessagingException me) {
			String message = "邮件发送失败，错误原因: \n"+me.getMessage();
			System.out.println(message);
			me.printStackTrace();
			Exception ex = null;  
			if((ex = me.getNextException()) != null) {
				System.out.println(ex.toString());
				ex.printStackTrace();
			}
		}
		
		return true;
	}
	
	/*****************************
	 * 把字符串数据转换成 Address数组
	 * @param strs	字符串数组
	 * @return	Address 数组
	 * @throws AddressException
	 */
	private static Address[] convertStringsToAddress(String[] strs) throws AddressException {
		if(strs == null)
			return null;
		
		Address[] addresses = new InternetAddress[strs.length];
		//赋值
		for (int i = 0; i < addresses.length; i++) {
			addresses[i] = new InternetAddress(strs[i]);
		}
		return addresses;
	}
}


