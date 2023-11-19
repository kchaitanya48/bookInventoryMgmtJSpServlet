package com.takeo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	public static String getString(Date d) {
		   return new SimpleDateFormat("yyyy-MM-dd").format(d);
		}
}
