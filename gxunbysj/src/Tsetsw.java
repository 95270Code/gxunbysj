import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Tsetsw {

	public static void main(String[] args) {
		 String s = "2017-02-13";
		 String[] ss = s.split("-");
		 Calendar calendar = Calendar.getInstance();
	     calendar.set(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2]), 0, 0, 0);   
	     Date date=calendar.getTime();
	     System.out.println(date); 
	     String sss[] = "2.jpg".split("\\.");
	     System.out.println(sss.toString());
	}
	
	public static void test1(){
		StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");   
        StringBuffer sb = new StringBuffer();   
        Random random = new Random();   
        int range = buffer.length();   
        for (int i = 0; i < 20; i ++) {   
            sb.append(buffer.charAt(random.nextInt(range)));   
        }   
        System.out.println(sb.toString());
	}

}
