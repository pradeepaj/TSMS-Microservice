package com.hcl.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.dto.ApplyReqDto;
import com.hcl.dto.ApplyResDto;
import com.hcl.dto.EmployeeResDto;
import com.hcl.dto.HolidayResDto;
import com.hcl.dto.TaskResDto;
import com.hcl.entity.TimeSheet;
import com.hcl.exception.TSMSException;
import com.hcl.repository.TimeSheetRepository;
import com.hcl.util.Constants;
/**
 * 
 * @author Pradeep AJ
 *
 */

@Service
public class TimesheetServiceImpl implements TimesheetService {
	
	private static final Logger logger = LoggerFactory.getLogger(TimesheetServiceImpl.class);
	
	@Autowired
	private TimeSheetRepository timeSheetRepository;

	RestTemplate restTemplate= new RestTemplate();
	
	/**
	 * this service implementation consume microservices
	 * microservice-1: employee service which validate the employee and return the employee details
	 * @param employeeId
	 * @return EmployeeResDto
	 * microservice-2: project service validate the project assignation for employee and return the status
	 * @param projectId
	 * @return TaskResDto
	 * microservice-3:lms service will validate the holiday and weekend and return the status
	 * @param List<LocalDate>
	 * @return HolidayResDto
	 * ======================================================
	 * @param ApplyReqDto
	 * @return ApplyResDto
	 */
	@Override
	public ApplyResDto submitTimesheet(ApplyReqDto reqDto) {
		EmployeeResDto employeeResDto=restTemplate.exchange(Constants.EMP_URL+"/"+reqDto.getEmployeeId(),
				HttpMethod.GET, null, EmployeeResDto.class).getBody();
		logger.info("Emp-Name={}",employeeResDto.getEmployeeName());
		
		TaskResDto taskResDto=restTemplate.exchange(Constants.PROJECT_URL+"/"+reqDto.getProjectId(),
				HttpMethod.GET, null, TaskResDto.class).getBody();
		logger.info("Project-Name={}",taskResDto.getProjectName());
		HttpEntity<List<LocalDate>> request = new HttpEntity<>(reqDto.getAppliedDate());
		HolidayResDto holidayResDto=restTemplate.exchange(Constants.HOLIDAY_URL,
				HttpMethod.POST, request, HolidayResDto.class).getBody();
		logger.info("Holiday list={}",holidayResDto.getMessage());
		
		Optional<List<TimeSheet>> listTimeSheet=timeSheetRepository.findByAppliedDateIn(reqDto.getAppliedDate());
		if(!listTimeSheet.isPresent()) {
		List<TimeSheet> timeSheetList=new ArrayList<>();
		reqDto.getAppliedDate().forEach(day->{
			TimeSheet timesheet=new TimeSheet();
			timesheet.setAppliedDate(day);
			timesheet.setEmployeeId(reqDto.getEmployeeId());
			timesheet.setEmployeeName(employeeResDto.getEmployeeName());
			timesheet.setProjectName(taskResDto.getProjectName());
			timesheet.setRmId(employeeResDto.getRmId());
			timesheet.setTimeSheetStatus("PENDING");
			timeSheetList.add(timesheet);
		});
		timeSheetRepository.saveAll(timeSheetList);
		ApplyResDto resDto=new ApplyResDto();
		resDto.setMessage(Constants.TIMESHEET_RESPONSE_MESSAGE);
		resDto.setStatusCode(Constants.CREATED);
		return resDto;
		}
		else {
			throw new TSMSException(Constants.TIMESHEET_EXCEPTION_RESPONSE_MESSAGE);
		}
	}

}
