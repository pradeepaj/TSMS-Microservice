package com.hcl.util;

import org.springframework.http.HttpStatus;

public class Constants {

	public static final int OK = HttpStatus.OK.value();
	public static final String PROJECT_RESPONSE_MESSAGE = "Valid Project-ID";
	public static final String PROJECT_EXCEPTION_RESPONSE_MESSAGE = "Your not assign to this project";

	private Constants() {

	}
}
