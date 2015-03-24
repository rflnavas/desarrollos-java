package com.mongoapp.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Configuration {
	
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy"); 
	
	static{
		DATE_FORMAT.setLenient(false);
	}
	private Configuration() {
	}
}
