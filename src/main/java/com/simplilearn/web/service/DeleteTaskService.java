package com.simplilearn.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.web.controller.SearchController;
import com.simplilearn.web.model.TaskEntity;
import com.simplilearn.web.model.TaskEntityCrudRepository;

@Service
public class DeleteTaskService {
	
	@Autowired
	TaskEntityCrudRepository taskEntityCrudRepository;
	
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	public boolean deleteTask(TaskEntity task) {
		logger.info("Inside the deleteTask service");
		
		Iterable<TaskEntity> tasks = taskEntityCrudRepository.findAll();
		
		for(TaskEntity taskEntity : tasks) {
			if(taskEntity.getId().equals(task.getId())) {
				taskEntityCrudRepository.deleteById(task.getId());
				return true;
			}
		}
		
		return false;
	}

}
