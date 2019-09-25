package com.hcl.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.HolidayReqDto;
import com.hcl.dto.HolidayResDto;
import com.hcl.entity.Holiday;
import com.hcl.exception.LmsException;
import com.hcl.repository.HolidayRepository;
import com.hcl.util.CheckWeekend;
import com.hcl.util.Constants;

/**
 * 
 * @author Pradeep AJ
 *
 */
@Service
public class LmsServiceImpl implements LmsService {
	private static final Logger logger = LoggerFactory.getLogger(LmsServiceImpl.class);

	@Autowired
	private HolidayRepository holidayRepository;
	/**
	 * @param List<Date>-HolidayReqDto
	 * @return HolidayResDto
	 * @exception LmsException
	 */
	
	@Override
	public HolidayResDto validateDate(List<LocalDate> reqDto) {
		CheckWeekend.findWeekend(reqDto);
		
		Optional<List<Holiday>> holiday =holidayRepository.findByHolidayDateIn(reqDto);
		if(holiday.isPresent()) {
			throw new LmsException(Constants.HOLIDAY_EXCEPTION_RESPONSE_MESSAGE);
		}
		else {
			HolidayResDto resDto=new HolidayResDto();
			logger.info("Not in the holiday list");
			resDto.setMessage(Constants.HOLIDAY_RESPONSE_MESSAGE);
			resDto.setStatusCode(Constants.OK);
			return  resDto;
		}
	}

}
