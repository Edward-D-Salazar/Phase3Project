package com.simplilearn.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.web.controller.SearchController;
import com.simplilearn.web.model.TaskEntity;
import com.simplilearn.web.model.TaskEntityCrudRepository;

@Service
public class UpdateTaskService {
	
	@Autowired
	TaskEntityCrudRepository taskEntityCrudRepository;
	
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	public boolean updateTask(TaskEntity task) {
		logger.info("Inside Update Task Service");
		
		Iterable<TaskEntity> tasks = taskEntityCrudRepository.findAll();
		
		for(TaskEntity taskEntity : tasks) {
			if(taskEntity.getId().equals(task.getId())) {
				taskEntity.setTaskName(task.getTaskName());
				taskEntity.setStartDate(task.getStartDate());
				taskEntity.setEndDate(task.getEndDate());
				taskEntity.setDescription(task.getDescription());
				taskEntity.setEmail(task.getEmail());
				taskEntity.setSeverity(task.getSeverity());
				taskEntityCrudRepository.save(task);
				return true;
			}
		}
		
		return false;
		
	}

}
