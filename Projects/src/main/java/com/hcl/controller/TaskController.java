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

import com.hcl.dto.TaskResDto;
import com.hcl.service.TaskService;

/**
 * 
 * @author Pradeep AJ
 *
 */

@RestController
@RequestMapping("/task")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class TaskController {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
	

	
	@Autowired
	private TaskService taskService;
	
	/**
	 * 
	 * @param projectId-NotNull
	 * @return TaskResDto
	 */
	@GetMapping("/{projectId}")
	public ResponseEntity<TaskResDto> findProjectDetails(@PathVariable int projectId){
		logger.info("Enter into TaskController findProjectDetails()");
		return new ResponseEntity<>(taskService.findProjectDetails(projectId),HttpStatus.OK);
	}
	

}
