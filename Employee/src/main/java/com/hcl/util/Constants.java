package com.hcl.util;

import org.springframework.http.HttpStatus;

public class Constants {

	public static final int OK = HttpStatus.OK.value();
	public static final String EMPLOYEE_RESPONSE_MESSAGE = "Valid Employee";
	public static final String EMPLOYEE_EXCEPTION_RESPONSE_MESSAGE = "Please Enter Valid Credentials";

	private Constants() {

	}
}
