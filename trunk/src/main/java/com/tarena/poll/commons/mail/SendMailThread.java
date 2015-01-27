package com.tarena.poll.commons.mail;

import com.tarena.poll.commons.log.LogOutPut;

/******************************
 * 发送邮件的线程
 * @author think-yejf
 *
 */
public class SendMailThread extends Thread {
	
	/** 所要发送邮件的相关信息 */
	private SendMailInfo smi;
	
	public SendMailThread(SendMailInfo smi) {
		this.smi = smi;
	}
	
	/**********************
	 * 在此处来进行发送邮件
	 */
	public void run() {
		LogOutPut.getInstance().debug(Thread.currentThread().getName()+" 开始发送邮件...");
		long t1 = System.currentTimeMillis();
		SodiMailSender.sendHtmlMail(smi);
		long t2 = System.currentTimeMillis();
		LogOutPut.getInstance().debug("邮件发送成功, 所耗费时间为："+(t2 - t1)+" ms.");
	}
}




