package es.hibernatewebapp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Constants {
	
	public static final DateFormat DDMMYYY_Format = new SimpleDateFormat("dd/MM/yyyy");
	
	protected static final String SCHEMA = "my_highschool";
	
	static{
		DDMMYYY_Format.setLenient(false);
	}
}
