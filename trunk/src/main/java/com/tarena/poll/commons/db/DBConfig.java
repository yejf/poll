package com.tarena.poll.commons.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/****************************
 * 本类负责读取 dbconfig.properties，
 * 并且提供方法获取所有KEY的值
 * @author sd0810
 * 采用单例模式
 */
public class DBConfig {

	/* 单例实例 */
	private static DBConfig instance;
	/* 存放属性文件内容 */
	private static Properties info = new Properties();
	/* 指定属性文件路径 */
	private static final String DEFAULT_PATH = "config/props/dbconfig.properties";
	
	private String path ;
	
	private DBConfig() {
		/* 默认的路径 */
//		configure(); 
	}
	
	/*public DBConfig configure() {
		this.path = DEFAULT_PATH;
		//return configure(DEFAULT_PATH);
	}*/
	static{
	//public DBConfig configure(String path) {
	
//		1. 获取属性文件的输入流
		InputStream in = null;
		try {
			in = Thread
					.currentThread()
					.getContextClassLoader()
					.getResourceAsStream("config/props/dbconfig.properties");
			//2. 调用 Properties对像的 load方法
			info.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//释放流
			if(in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static synchronized
					DBConfig getInstance() {
		
		if(instance == null){
			//System.out.println("===");
			instance = new DBConfig();
		}
		return instance;
	}
	
	/****************************
	 * 本方法是对外提供：通过KEY值来获取VALUE
	 * @param key 属性文件中的key值
	 * @return 对应的 value值
	 */
	public String getValue(String key) {
		return info.getProperty(key);
	}
	
}








