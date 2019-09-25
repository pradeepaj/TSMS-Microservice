package com.hcl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.ApplyReqDto;
import com.hcl.dto.ApplyResDto;
import com.hcl.service.TimesheetService;

/**
 * 
 * @author Pradeep AJ
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class TimesheetController {
	
	private static final Logger logger = LoggerFactory.getLogger(TimesheetController.class);
	
	@Autowired
	private  TimesheetService timesheetService;
	
	/**
	 * 
	 * @param ApplyReqDto
	 * @return ApplyResDto
	 */
	@PostMapping("/tsms")
	public ResponseEntity<ApplyResDto> submitTimesheet(@RequestBody ApplyReqDto reqDto){
		logger.info("Enter into TimesheetController  submitTimesheet()");
		return new ResponseEntity<>(timesheetService.submitTimesheet(reqDto),HttpStatus.CREATED);
	}

}
