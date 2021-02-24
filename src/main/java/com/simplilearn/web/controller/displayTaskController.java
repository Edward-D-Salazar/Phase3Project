package com.simplilearn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.web.model.TaskEntity;
import com.simplilearn.web.model.TaskEntityCrudRepository;

@RestController
public class displayTaskController {
	
	@Autowired
	TaskEntityCrudRepository taskEntityCrudRepository;
	
	@GetMapping(path = "/displayTasks")
	public String displayTask() {
		Iterable<TaskEntity> tasks = taskEntityCrudRepository.findAll();
		
		String ourTasks = "<h2>Our Tasks</h2>";
		
		for(TaskEntity task : tasks) {
			ourTasks = ourTasks + "<p>" + task.getTaskName() + "</p>";
		}
		
		return ourTasks;
	}

}
