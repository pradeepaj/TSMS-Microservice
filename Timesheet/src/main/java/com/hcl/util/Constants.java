package com.hcl.util;

import org.springframework.http.HttpStatus;

public class Constants {

	public static final int CREATED = HttpStatus.CREATED.value();
	public static final String TIMESHEET_RESPONSE_MESSAGE = "Timesheet submitted successfully";
	public static final String TIMESHEET_EXCEPTION_RESPONSE_MESSAGE = "You have already submitted timesheet for this day";
	
	
	
	public static final String EMP_URL="http://localhost:9093/hcl/employee";
	public static final String PROJECT_URL="http://localhost:9099/hcl-project/task";
	public static final String HOLIDAY_URL="http://localhost:9088/hcl-holiday/lms";


	private Constants() {

	}
}
