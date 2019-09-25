package com.hcl.util;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.hcl.exception.LmsException;

public class CheckWeekend {
	
	public static void findWeekend(List<LocalDate> weekend) {
		
		weekend.stream().forEach(day->{
			Calendar cal = new GregorianCalendar(day.getYear(),day.getDayOfMonth(),day.getDayOfMonth());
			  int dayy = cal.get(Calendar.DAY_OF_WEEK);
			if (dayy == Calendar.SATURDAY || dayy == Calendar.SUNDAY) {
				
				 throw new LmsException("You can't apply timesheet on Weekends");
			}
		});
		
		
		
	}

}
