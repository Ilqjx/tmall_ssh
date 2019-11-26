package com.how2java.tmall.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {
	
	public static Date t2d(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	public static Timestamp d2t(Date date) {
		return new Timestamp(date.getTime());
	}
	
}
