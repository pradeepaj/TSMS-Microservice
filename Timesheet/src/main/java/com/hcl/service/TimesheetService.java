package com.hcl.service;

import com.hcl.dto.ApplyReqDto;
import com.hcl.dto.ApplyResDto;

public interface TimesheetService {

	ApplyResDto submitTimesheet(ApplyReqDto reqDto);

	

}
