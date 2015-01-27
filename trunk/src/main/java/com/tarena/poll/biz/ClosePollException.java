/**
 * 
 */
package com.tarena.poll.biz;

/**
 * @author Administrator
 *
 */
public class ClosePollException extends BizException {

	/**
	 * 
	 */
	public ClosePollException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ClosePollException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param errorCode
	 * @param cause
	 */
	public ClosePollException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ClosePollException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 * @param errorCode
	 */
	public ClosePollException(Throwable cause, String errorCode) {
		super(cause, errorCode);
		// TODO Auto-generated constructor stub
	}

}
