package com.tarena.poll.commons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class EncryptionUtilBySimple {
	/**
	 * ��Կ
	 */
	private static Character KEY;
	/**
	 * �����Կ�ļ���·��
	 */
	private static String FILE_NAME = "com" + File.separator + "tarena" + File.separator + "poll" + File.separator + "commons" + File.separator + "key.txt";
	static {
		ObjectInputStream ois = null;
		InputStream in = null;
		try {
			in = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(FILE_NAME);
			ois = new ObjectInputStream(in);
			KEY = (Character) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static float parseToCryptograph(float data) {
		int myKey=KEY;
		float myData=data*10;
		int myIntData=(int) myData;
		int secIntData=myIntData^myKey;
		float secFlaData=secIntData;
		float secFlaData2=secFlaData/10;
		return secFlaData2*25;
	}
	public static float getDataFromCryptograph(float secData){
		int myKey=KEY;
		secData/=25;
		secData*=10;
		int secIntData=(int) secData;
		secIntData^=myKey;
		float myData=secIntData;
		myData/=10;
		return myData;
	}
	public static void main(String[] args){
		float secData=parseToCryptograph(0.5f);
		System.out.println(secData);
		float myData=getDataFromCryptograph(secData);
		System.out.println(myData);
	}
}
