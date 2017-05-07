package com.util;

public class AddNumber {
	public static String increaseNumber(String s1){
		String[] s2 = s1.split("-");
		String s3 = s2[1];
		int s4 = Integer.parseInt(s3);
		int s5 = s4+1;
		String s6 = s2[0]+"-"+s5;
		return s6;
	}
}
