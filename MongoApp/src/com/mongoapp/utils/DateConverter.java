package com.mongoapp.utils;

import java.text.ParseException;
import java.util.Date;

public class DateConverter {
	
	private DateConverter() {
	}
	
	public static Date toDate(String date) throws ParseException{
		Date d = Configuration.DATE_FORMAT.parse(date);
		return d;
	}
	
	public static String toString(Date date) throws ParseException{
		String d = Configuration.DATE_FORMAT.format(date);
		return d;
	}
	
}
