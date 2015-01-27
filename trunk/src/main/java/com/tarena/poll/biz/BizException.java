/**
 * 
 */
package com.tarena.poll.biz;

import com.tarena.poll.exception.PollRuntimeException;

/**
 * @author Administrator
 *
 */
public class BizException extends PollRuntimeException {

	/**
	 * 
	 */
	public BizException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BizException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param errorCode
	 * @param cause
	 */
	public BizException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public BizException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 * @param errorCode
	 */
	public BizException(Throwable cause, String errorCode) {
		super(cause, errorCode);
		// TODO Auto-generated constructor stub
	}

}
