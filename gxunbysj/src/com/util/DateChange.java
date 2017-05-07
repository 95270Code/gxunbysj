package com.util;

import java.util.Calendar;
import java.util.Date;

public class DateChange {
	public static Date changeDate(String s){
		 Date date = null;
		 if(s.contains("-")){
			 String[] ss = s.split("-");
			 Calendar calendar = Calendar.getInstance();
		     calendar.set(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2]), 0, 0, 0);   
		     date = calendar.getTime(); 
		 }
		 return date;
	}
}
