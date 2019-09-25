package com.hcl.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.EmployeeResDto;
import com.hcl.entity.Employee;
import com.hcl.exception.EmployeeNotFoundException;
import com.hcl.repository.EmployeeRepository;
import com.hcl.util.Constants;
/**
 * 
 * @author Pradeep AJ
 *
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * 
	 * @param employeeId-Notnull
	 * @return EmployeeResDto-emplyeeDetails
	 * @exception EmployeeNotFoundException-if employee not found
	 */
	
	@Override
	public EmployeeResDto validateEmployee(Integer employeeId) {
		
		Optional<Employee> employee=employeeRepository.findByEmployeeId(employeeId);
		if(employee.isPresent()) {
			Employee emp=employee.get();
			logger.info("Valid EMployee={}",emp.getEmployeeId());
			EmployeeResDto resDto=new EmployeeResDto();
			resDto.setEmployeeName(emp.getEmployeeName());
			resDto.setMessage(Constants.EMPLOYEE_RESPONSE_MESSAGE);
			resDto.setRmId(emp.getRmId());
			resDto.setStatusCode(Constants.OK);
			return resDto;
			
		}else {
			throw new EmployeeNotFoundException(Constants.EMPLOYEE_EXCEPTION_RESPONSE_MESSAGE);
		}
		
	}

}
