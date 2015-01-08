package day8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Birthday {
  	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
		
		Calendar calendar = Calendar.getInstance(Locale.UK);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy",Locale.UK);
		
		System.out.println("Current date: "+formatter.format(date));

		calendar.set(1973, 00, 20);
		System.out.println("My birthday: "+formatter.format(calendar.getTime()));
		System.out.println("It was in "+calendar.getDisplayName(calendar.DAY_OF_WEEK, calendar.LONG, Locale.UK));
				
		try {
			date = formatter.parse("20 Jan 1973");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("My birthday: "+formatter.format(date));
		
		
	}

}
