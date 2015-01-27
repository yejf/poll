/**
 * 
 */
package com.tarena.poll.biz;

/**
 * @author Administrator
 *
 */
public class LoginException extends BizException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9010359602191062152L;

	/**
	 * 
	 */
	public LoginException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LoginException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param errorCode
	 * @param cause
	 */
	public LoginException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public LoginException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 * @param errorCode
	 */
	public LoginException(Throwable cause, String errorCode) {
		super(cause, errorCode);
		// TODO Auto-generated constructor stub
	}

}
