package com.util;

import java.util.Random;

public class RedomPID {
	public static String createPID(){
		StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");   
        StringBuffer sb = new StringBuffer();   
        Random random = new Random();   
        int range = buffer.length();   
        for (int i = 0; i < 20; i ++) {   
            sb.append(buffer.charAt(random.nextInt(range)));   
        }   
		return sb.toString();
	}
}
