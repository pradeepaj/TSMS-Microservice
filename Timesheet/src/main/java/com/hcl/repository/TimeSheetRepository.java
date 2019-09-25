/**
 * 
 */
package com.hcl.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.TimeSheet;

/**
 * @author Pradeep AJ
 *
 */

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer> {

	Optional<List<TimeSheet>> findByAppliedDateIn(List<LocalDate> appliedDate);

}
