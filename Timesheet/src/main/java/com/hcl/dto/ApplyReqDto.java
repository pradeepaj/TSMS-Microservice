package com.hcl.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyReqDto {
	
	private List<LocalDate> appliedDate;
	private int employeeId;
	private int projectId;


}
