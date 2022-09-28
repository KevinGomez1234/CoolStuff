package co.kevingomez;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateDemos {
	public static void main(String[] args) throws Exception {
		/*
		 * Year -> yyyy => 1999 (example) Month in year -> MM -> 07 Day in month -> dd
		 * -> 30
		 * 
		 * Hour in am/pm -> hh -> 1-12 Minute in hour -> mm -> 0-59 Second -> ss -> 0-59
		 * -> milisecond -> SSS -> 0-999
		 * 
		 * deci-second => 0.1 => one tenth of a second cent-second => 0.01 => one
		 * hundreth of a second mili-second => 0.001 => one thousandth of a second
		 * micro-second => 0.000001 => one millionth of a second nano-second =>
		 * 0.000000001 => one billionth of a second
		 * 
		 * Be aware that java.util.Date objects do not contain any timezone information
		 * by themselves - you cannot set the timezone on a Date object. The only thing
		 * that a Date object contains is a number of milliseconds since the "epoch" - 1
		 * January 1970, 00:00:00 UTC.
		 * 
		 * The epoch represents UNIX time 0 (midnight at the start of January 1, 1970)
		 * 
		 * UNIX timestamp, refers to the number of seconds that have elapsed since the
		 * epoch.
		 * 
		 * You can format it however with SimpleDateFormat as shown below for proper
		 * timezones
		 * 
		 * Date vs Instant
		 * => you need a timestamp (moment in utc)  use Date or Instant
		 * => No time-zone / region
		 * 
		 * => date and time of day use LocalDateTime
		 * 
		 * Calendar trivia: We use the Gregorian Calendar system => used to use Julius calendar system
		 * every year divisible by 4 we have a leap year (extra day)
		 * 
		 * AD and BC started at the same point 1 AD == 1 BC
		 * 
		 * Timeline looks like this
		 * 
		 * Earth was born ... 3 BC, 2BC, 1BC -> 1AD, 2 AD .... 2022 AD
		 *  Day after December 31, 1 BC => Januar 1, 1 AD 
		 *  Notice there is no year 0, this is why the start of a new millenium is the year after 1900 -> 1901 for example and 2000->2001 
		 *  Past milleniums -> 1901
		 *  
		 */
		String yearMonthDayTimePattern = "yyyy-MM-dd hh:mm:ss.SSS";
		String yearMonthDayTimePatternTimeZone = "yyyy-MM-dd hh:mm:ss.SSS z";
		SimpleDateFormat yearMonthDayTime = new SimpleDateFormat(yearMonthDayTimePattern);
		SimpleDateFormat yearMonthDayTimeZone = new SimpleDateFormat(yearMonthDayTimePatternTimeZone);
		yearMonthDayTime.setTimeZone(TimeZone.getTimeZone("GMT"));
		yearMonthDayTimeZone.setTimeZone(TimeZone.getTimeZone("GMT"));
		// Date really just captures the current date/time, however it is a legacy
		// class. java.time.* are simply better. Date just uses
		Date date = yearMonthDayTime.parse("1999-03-04 04:03:21.999");
		String stringDate = yearMonthDayTimeZone.format(date);
		System.out.println("ok: " + stringDate);
		Date d = new Date();
		long milliSecondsSinceEpoch = d.getTime();
		long secondsSinceEpoch = milliSecondsSinceEpoch * 1000;
		System.out.println("Seconds since epoch: " + secondsSinceEpoch);
		long millis = System.currentTimeMillis();
		System.out.println("Seconds since last epoch: " + millis * 1000);

		
		//LocalDateTime is a datetime without a time zone -> immutable date-time object NO TIME ZONE
		//Description of the date It cannot represent an instant on the time-line without additional information such as an offset or time-zone. Just used to get user friendly calendary data as well as wall clock data. Equals methods should be used for comparisons
		//Demo
		LocalDateTime ldt = LocalDateTime.now();
		LocalDateTime ldt2 = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("CST"));
		System.out.println("ldt2: " + ldt2);
		int currentDayOfMonth = ldt.getDayOfMonth();
		System.out.println("ldt: " + ldt + "Day of month: " + currentDayOfMonth);
		
		
		//MONENT WITH TIME-ZONE XmlGregorianCalendar and GregorianCalendar
		
		//Creating a date with Instant
		
		// String nowFormattedString = isoFormat.format(now);

//		System.out.println("nowWithInstant: " + nowWithInstant);
//		System.out.println("nowFormattedString: " + nowFormattedString);
//		
//		//Easier solution 
//		
//		Instant i = now.toInstant();
//		System.out.println("easier: " + i);
//        Date current_date = new Date();
//
//        Date past_date = regularFormat.parse("1999-09-23T09:41:00");

		GregorianCalendar gc = new GregorianCalendar();
		GregorianCalendar gc2 = new GregorianCalendar();

//        gc.setTime(current_date);
//        gc2.setTime(past_date);
		// Create Date Object

//        XMLGregorianCalendar gCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
//        XMLGregorianCalendar gCal2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc2);
//
//        int res = gCal.compare(gCal2);
//        boolean isPast = res > 0 ? true : false;
//        System.out.println("is past date? " + isPast);
//        
//        // current date time in standard format
//        System.out.println("Standard Format :- "
//                           + current_date);
// 
//        XMLGregorianCalendar xmlDate = null;
// 
//        // Gregorian Calendar object creation
// 
//        // giving current date and time to gc
//        gc.setTime(current_date);
// 
//        try {
//            xmlDate = DatatypeFactory.newInstance()
//                          .newXMLGregorianCalendar(gc);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
// 
//        // current date time in XMLGregorian Calendar format
//        System.out.println("XMLGregorianCalendar Format :- "
//                           + xmlDate);
	}
}
