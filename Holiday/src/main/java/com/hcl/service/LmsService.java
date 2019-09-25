package com.hcl.service;

import java.time.LocalDate;
import java.util.List;

import com.hcl.dto.HolidayReqDto;
import com.hcl.dto.HolidayResDto;

public interface LmsService {

	

	HolidayResDto validateDate(List<LocalDate> reqDto);

}
