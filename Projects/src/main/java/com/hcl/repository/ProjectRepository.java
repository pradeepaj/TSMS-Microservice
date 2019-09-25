package com.hcl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.HclProjects;
@Repository
public interface ProjectRepository extends JpaRepository<HclProjects, Integer> {

	Optional<HclProjects> findByProjectId(int projectId);

}
