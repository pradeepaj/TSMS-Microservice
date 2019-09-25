package com.hcl.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.TaskResDto;
import com.hcl.entity.HclProjects;
import com.hcl.exception.ProjectNotAvailableException;
import com.hcl.repository.ProjectRepository;
import com.hcl.util.Constants;
/**
 * 
 * @author Pradeep AJ
 *
 */

@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Autowired
	private ProjectRepository projectRepository;
	
	/**
	 * @param projectId-NotNull
	 * @return TaskResDto
	 * @exception ProjectNotAvailableException -if project is not available
	 */
	
	@Override
	public TaskResDto findProjectDetails(int projectId) {
		Optional<HclProjects> project=projectRepository.findByProjectId(projectId);
		if(project.isPresent()) {
			HclProjects hclProject=project.get();
			logger.info("Assaigned project is ={}",hclProject.getProjectName());
			TaskResDto resDto=new TaskResDto();
			resDto.setProjectName(hclProject.getProjectName());
			resDto.setMessage(Constants.PROJECT_RESPONSE_MESSAGE);
			resDto.setStatusCode(Constants.OK);
			return resDto;
		}
		else {
			throw new ProjectNotAvailableException(Constants.PROJECT_EXCEPTION_RESPONSE_MESSAGE);
		}
	}

}
