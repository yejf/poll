package com.tarena.poll.commons.mail;

import com.tarena.poll.commons.db.DBConfig;

public class MailMain {

	public static void main(String[] args) {
		SendMailInfo smi = new SendMailInfo();
		smi.setTo(new String[]{"yejf@sz-tz.org","hujl@sz-tz.org"});
		smi.setCc(new String[] {"yejf@sz-tz.org"});
		smi.setSubject("测试邮件.");
		smi.setContent("这是一封经过JAVA MAIL所发出来的测试邮件.请不要回复.");
		smi.setFrom("poll@sz-tz.org");
		smi.setSmtp_host("smtp.qq.com"); //smtp.qq.com
		smi.setSmtp_port("25");
		smi.setValidate(true);
		smi.setUsername("poll@sz-tz.org");
		smi.setPassword("qazwsx1");
		
//		SodiMailSender sms = new SodiMailSender();
	/*	boolean b = SodiMailSender.sendTextMail(smi);
		SodiMailSender.sendHtmlMail(smi);
		
		if(b) {
			System.out.println("发邮件成功...");
		}*/
		
		Thread t  = new SendMailThread(smi);
		t.start();
		
//		SodiMailSender.sendHtmlMail(smi);
		
		System.out.println("主程序正常结束....");
		
		/*DBConfig config = DBConfig.getInstance().configure("config/props/mail.properties");
		String host = config.getValue("mail.smtp.host");
		String to = config.getValue("close.poll.mail.to");
		
		System.out.println(host+"\t"+to);
		config.configure();
		
		System.out.println(host+"\t"+to);
		System.out.println(config.getValue("driver")+"\t"+config.getValue("url"));*/
		
	}
}
