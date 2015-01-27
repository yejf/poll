package com.tarena.poll.dao;

import com.tarena.poll.exception.PollRuntimeException;

public class DaoException extends PollRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9042206212938523471L;

	public DaoException() {
		// TODO Auto-generated constructor stub
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DaoException(Throwable cause, String errorCode) {
		super(cause, errorCode);
		// TODO Auto-generated constructor stub
	}

}
