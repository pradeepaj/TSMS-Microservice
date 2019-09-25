package com.hcl.util;

import org.springframework.http.HttpStatus;

public class Constants {

	public static final int OK = HttpStatus.OK.value();
	public static final String HOLIDAY_RESPONSE_MESSAGE = "Requested Date's not in the holiday list";
	public static final String HOLIDAY_EXCEPTION_RESPONSE_MESSAGE = "You can't apply timesheet on holiday";

	private Constants() {

	}
}
