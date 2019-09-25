package com.hcl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDto> globalExceptionHandler(Exception exception, WebRequest request) {
		ResponseDto errorResponse = new ResponseDto();
		errorResponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpStatusCodeException.class)
	public ResponseEntity<String> globalMicroserviceExceptionHandler(HttpStatusCodeException exception,
			WebRequest request) {
		return ResponseEntity.status(exception.getRawStatusCode()).body(exception.getResponseBodyAsString());
	}

	@ExceptionHandler(TSMSException.class)
	public ResponseEntity<ResponseDto> tsmsExceptionHandler(TSMSException ex, WebRequest request) {

		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(ex.getMessage());
		responseDto.setStatusCode(400);
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);

	}

}