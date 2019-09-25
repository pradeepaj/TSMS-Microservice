package com.hcl.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResDto {
	
	private String projectName;
	private String message;
	private int statusCode;
}
