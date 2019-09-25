package com.hcl.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TimeSheet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int timeSheetId;
	private LocalDate appliedDate;
	private String employeeName;
	private int employeeId;
	private int rmId;
	private String projectName;
	private String timeSheetStatus;
	
	

}
