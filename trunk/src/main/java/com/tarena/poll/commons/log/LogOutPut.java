package com.tarena.poll.commons.log;


import org.apache.log4j.Logger;

/**
 * Apache LOG4J Log Management 2008-9-9.
 * 
 * @author [Tarena Training Group]
 * @version 1.0
 * @since JDK1.6suggestion)
 * @author madf
 */

public class LogOutPut {

	/** The instance. */
	private static LogOutPut instance = null;

	/**
	 * Gets the instance.
	 * 
	 * @return the instance
	 */
	public static synchronized LogOutPut getInstance() {
		if (instance == null) {
			instance = new LogOutPut();
			return instance;
		}
		return instance;
	}

	/** The log. */
	 private static Logger logger = null;
	/**
	 * The Constructor.
	 */
	public LogOutPut() {
		 logger = Logger.getLogger("Tarena poll");
	}

	/**
	 * Info.
	 * 
	 * @param logs
	 *            the logs
	 */
	public void info(String logs) {
		 logger.info(logs);
		System.out.println("[info]: " + logs);
	}

	/**
	 * Debug.
	 * 
	 * @param logs
	 *            the logs
	 */
	public void debug(String logs) {
		 logger.debug(logs);
		System.out.println("[debug]: " + logs);
	}

	/**
	 * Warn.
	 * 
	 * @param logs
	 *            the logs
	 */
	public void warn(String logs) {
		 logger.warn(logs);
		System.out.println("[warn]: " + logs);
	}

	/**
	 * Error.
	 * 
	 * @param logs
	 *            the logs
	 */
	public void error(String logs) {
		 logger.error(logs);
		System.out.println("[error]: " + logs);
	}

	/**
	 * Fatal.
	 * 
	 * @param logs
	 *            the logs
	 */
	public void fatal(String logs) {
		 logger.fatal(logs);
		System.out.println("[fatal]: " + logs);
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the args
	 */
	public static void main(String[] args) {
		LogOutPut.getInstance().info("out info.");
		LogOutPut.getInstance().debug("out debug.");
		LogOutPut.getInstance().warn("out warn.");
		LogOutPut.getInstance().error("out error.");
		LogOutPut.getInstance().fatal("out fatal.");
	}
}
