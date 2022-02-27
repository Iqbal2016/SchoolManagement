/**
 * 
 */
package com.iqbal.bean;

/**
 * @author TCS
 *
 */
import java.util.Calendar;
import java.util.Date;

public class Utility {

	private static Date stringDate;


	public static java.sql.Timestamp getCurrentTimeStamp() {
		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();
	
		// 2) get a java.util.Date from the calendar instance.
		//	 this date will represent the current instant, or "now".
		Date now = calendar.getTime();
	
		// 3) a java current time (now) instance
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}
}
