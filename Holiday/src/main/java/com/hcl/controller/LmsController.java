package com.hcl.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.HolidayResDto;
import com.hcl.service.LmsService;

/**
 * 
 * @author Pradeep AJ
 *
 */

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class LmsController {
	private static final Logger logger = LoggerFactory.getLogger(LmsController.class);
	
	@Autowired
	private LmsService lmsService;
	
	/**
	 * 
	 * @param HolidayReqDto 
	 * @return HolidayResDto
	 */
	
	@PostMapping("/lms")
	public ResponseEntity<HolidayResDto> validateDate(@RequestBody List<LocalDate> reqDto){
		logger.info("Enter into  LmsController validateDate()");
		return new ResponseEntity<>(lmsService.validateDate(reqDto), HttpStatus.OK);
	}
}
