package com.simplilearn.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.web.controller.SearchController;
import com.simplilearn.web.model.TaskEntity;
import com.simplilearn.web.model.TaskEntityCrudRepository;

@Service
public class CreateTaskService {
	
	@Autowired
	TaskEntityCrudRepository taskEntityCrudRepository;
	
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	public boolean createTask(TaskEntity task) {
		logger.info("Inside Create Task Service");
		
		taskEntityCrudRepository.save(task);
		
		return true;
		
	}

}
