package com.tarena.poll.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*******************************************************************************
 * 应用运行异常 所有本应用系统异常的父类
 * 
 * <pre>
 * 	如：
 * 	&lt;messages&gt;
 * 		&lt;message id=&quot;exceptions&quot;&gt;
 * 			&lt;locale language=&quot;zh&quot;&gt;
 * 				&lt;entry key=&quot;BIZ-1000&quot;&gt;系统启动失败&lt;/entry&gt;
 * 				. . .
 * 			&lt;/local&gt;
 * 		&lt;/message&gt;
 * 	&lt;/messages&gt;	
 * </pre>
 * 
 * @author yejf
 * @since 1.0
 * @version 1.0
 */
public class PollRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(PollRuntimeException.class);
	
	private static final String NO_ERROR_CODE = "NO ERROR CODE ";
	/* 错误代码 */
	private String errorCode;

	public PollRuntimeException() {
		super();
		this.errorCode = NO_ERROR_CODE;
		/* 加入日志 */
		log(errorCode);
	}

	

	public PollRuntimeException(String message, Throwable cause) {
		super(message, cause);
		this.errorCode = NO_ERROR_CODE;
		/* 加入日志 */
		log(errorCode,message,cause);
	}
	
	/***********************************
	 * 
	 * @param message  异常消息
	 * @param errorCode	异常代码
	 * @param cause  原因
	 */
	public PollRuntimeException(String message, String errorCode,Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		/* 加入日志 */
		log(errorCode,message,cause);
	}

	
	public PollRuntimeException(String message) {
		super(message);
		errorCode = NO_ERROR_CODE;
		/* 加入日志 */
		log(errorCode,message,null);
	}

	public PollRuntimeException(Throwable cause,String errorCode) {
		super(cause);
		this.errorCode = errorCode;
		/* 加入日志 */
		log(errorCode,null,cause);
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return (errorCode);
	}
	
	
	private void log(String ec) {
		log.error(ec);
	}
	
	private void log(String ec,String msg, Throwable cause) {
		StringBuffer str = new StringBuffer();
		if(msg != null) {
			str.append(msg);
		}
		log.error(ec+"|:|:| "+str.toString(),cause);
	}
}






