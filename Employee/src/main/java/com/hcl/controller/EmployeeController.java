package com.hcl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.EmployeeResDto;
import com.hcl.service.EmployeeService;
/**
 * 
 * @author Pradeep AJ
 *
 */

@RestController
@RequestMapping("/employee")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 
	 * @param employeeId-Notnull
	 * @return EmployeeResDto
	 */
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeResDto> validateEmployee(@PathVariable Integer employeeId){
		logger.info("Enter into EmployeeController validateEmployee()");
		return new ResponseEntity<>(employeeService.validateEmployee(employeeId), HttpStatus.OK);
	}

}
