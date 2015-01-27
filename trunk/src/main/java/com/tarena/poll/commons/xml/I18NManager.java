package com.tarena.poll.commons.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.i18n.MessageManager;
import org.apache.commons.i18n.XMLMessageProvider;

/**********************
 * 
 * @see XMLMessageProvider
 * @author yejf
 * @since 1.0
 */
public class I18NManager {

	private static I18NManager instance ;
	
	private static String defaultPath = "";
	
	private static Locale defaultLoacle = Locale.ENGLISH;
	
	private I18NManager() {
//		configure();
	}
	
	public synchronized static I18NManager getInstance() {
		if(instance == null)
			instance = new I18NManager();
		return instance;
	}
	
	public void setDefaultPath(String path) {
		defaultPath = path;
	}
	
	public void setDefaultLocale(Locale l) {
		defaultLoacle = l;
	}
	
	private I18NManager configure() {
		return configure(defaultPath);
	}

	public I18NManager configure(String path) {
		InputStream in = null;
		try {
			in = Thread
					.currentThread()
					.getContextClassLoader()
					.getResourceAsStream(path);
			
			XMLMessageProvider.install("", in);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null)
					in.close();
			} catch (IOException ee) {
				ee.printStackTrace();
			}
		}
		
		return this;
	}
	
	public Map getEntry(String id) {
		return MessageManager.getEntries(id, defaultLoacle);
	}
	
	public Map getEntry(String providerId, String id) {
		return MessageManager.getEntries(providerId, id, defaultLoacle);
	}
	
	public Map getEntry(String id, Locale vLocale) {
		return MessageManager.getEntries(id, vLocale);
	}
	
	public Map getEntry(String providerId, String id, Locale vLocale) {
		return MessageManager.getEntries(providerId, id, vLocale);
	}
	
	public String getText(String id, String key) {
		return MessageManager.getText(id, key, null, defaultLoacle);
	}
	
	public String getText(String id, String key, Locale vLocale) {
		return MessageManager.getText(id, key, null, vLocale);
	}
	
	public String getText(String id, String key, Object[] args, Locale vLocale) {
		return MessageManager.getText(id, key, args, vLocale);
	}
	
}








