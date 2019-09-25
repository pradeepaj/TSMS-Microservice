package com.hcl.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

	Optional<List<Holiday>> findByHolidayDateIn(List<LocalDate> reqDto);

}
