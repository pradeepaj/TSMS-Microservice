package com.hcl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(ProjectNotAvailableException.class)
	public ResponseEntity<ResponseDto> ProjectNotAvailableExceptionHandler(ProjectNotAvailableException ex, WebRequest request) {

		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(ex.getMessage());
		responseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
    	return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);

	}

}