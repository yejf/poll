package com.tarena.poll.commons;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/****************************
 * 信息摘要加密： MD5
 * @author yejf
 *
 */
public class MD5 {

	private static Log log = LogFactory.getLog(MD5.class);
	
	/****************************************
	 * 根据给定的字符串 采用MD5单向加密算法加密
	 * 
	 * 由于MD5是单向加密算法，所以，在本系统中，它可以用来
	 * 加密 用户密码, 但对于 分数的加密不适合,因为它没有办法还原
	 * @param src 原始字符数据
	 * @return
	 */
	public static String encode(String src) {
		StringBuffer sbDest = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(src.getBytes());
			byte[] dest = md.digest();
			for (int i = 0; i < dest.length; i++) {
				String s = Integer.toHexString(dest[i] & 0xff);
				if(s.length() == 1) {
					sbDest.append("0");
				}
				sbDest.append(s);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			log.error("加密失败...",e);
		}
		return sbDest.toString();
	}
	
	/******************************
	 * 根据给定的 字节数据来通过MD5加密
	 * @param in
	 * @return
	 */
	public static byte[] md5(byte[] in) {
		byte[] out = new byte[8];
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("MD5");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		md.reset();
		
		md.update(in);
		
		out = md.digest();
		
		return out;
	}
	
	/*****************
	 * 同上
	 * @param in
	 * @param len
	 * @return
	 */
	public static byte[] md5(byte[] in, int len) {
		byte[] out = new byte[8];
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("MD5");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		md.reset();
		
		md.update(in, 0, len);
		
		out = md.digest();
		
		return out;
	}
	
	/***********************
	 * 比较两个字符数组数据是否一致;
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static boolean byteCompare(byte[] v1, byte[] v2) {
		if(v1.length == v2.length) {
			for(int i=0;i<v1.length;i++) {
				byte b = v1[i];
				byte c = v2[i];
				if(b != c) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String pwd1 = "admin";
		String pwd2 = "admin";
		String p2 = encode(pwd1);
		String p3 = encode(pwd2);
		System.out.println(p2+"\t"+p2.length());
		System.out.println(p3+"\t"+p3.length());
		
	}
}







