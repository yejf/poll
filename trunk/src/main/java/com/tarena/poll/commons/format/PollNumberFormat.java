package com.tarena.poll.commons.format;

import java.text.NumberFormat;

import com.tarena.poll.commons.db.DBConfig;

public class PollNumberFormat {
	private static int minFlaction=Integer.parseInt(DBConfig.getInstance().getValue("minFraction"));
	private static int maxFlaction=Integer.parseInt(DBConfig.getInstance().getValue("maxFraction"));
	public static double formatDouble(double d){
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(maxFlaction);
		nf.setMinimumFractionDigits(minFlaction);
		String s=nf.format(d);
		return Double.parseDouble(s);		
	}
	
	public static float formatFloat(float f) {
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		nf.setMinimumFractionDigits(1);
		String s = nf.format(f);
		return Float.parseFloat(s);
	}
//	public static void main(String[] args){
//		double d=2.1345;
//		double d1=PollNumberFormat.formatDouble(d);
//		float f=(float)d1;
//		System.out.println(f+"     "+d1);
//	}
}
