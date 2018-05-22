package com.dh.commons;

import java.text.SimpleDateFormat;

public class DateFormateService{
	
	private static final String pattern = "yyyy-MM-dd";
	
	private static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<>();
	
	public static SimpleDateFormat getSimpledateFormat() {
		SimpleDateFormat df = dateFormat.get();
		if(df == null) {
			df = new SimpleDateFormat(pattern);
			dateFormat.set(df);
		}
		return df;
	}
	
}




