/**
 * 
 */
package com.tarena.poll.biz;

/**
 * @author Administrator
 *
 */
public class ActivatePollException extends BizException {

	/**
	 * 
	 */
	public ActivatePollException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ActivatePollException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param errorCode
	 * @param cause
	 */
	public ActivatePollException(String message, String errorCode,
			Throwable cause) {
		super(message, errorCode, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ActivatePollException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 * @param errorCode
	 */
	public ActivatePollException(Throwable cause, String errorCode) {
		super(cause, errorCode);
		// TODO Auto-generated constructor stub
	}

}
