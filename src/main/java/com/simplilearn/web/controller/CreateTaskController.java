package com.simplilearn.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplilearn.web.model.TaskEntity;
import com.simplilearn.web.service.CreateTaskService;

@Controller
public class CreateTaskController {
	
	@Autowired
	CreateTaskService service;
	
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping(value = "/createTask", method = RequestMethod.GET)
	public String showCreateTask(ModelMap model) {
		logger.info("Inside Create Task");
		model.addAttribute("createTask", new TaskEntity());
		return "createTask";
	}
	
	@RequestMapping(value = "/createTask", method = RequestMethod.POST)
	public String processCreateTask(@ModelAttribute("createTask") TaskEntity createTask, ModelMap model) {
		logger.info("Inside processCreatTask");
		if(!createTask.equals(null) && createTask.getTaskName() != "" && createTask.getStartDate() != "" && 
				createTask.getSeverity() != "" && createTask.getEndDate() != "" && createTask.getEmail() != ""
				&& createTask.getDescription() != "") {
			service.createTask(createTask);
			return "taskCreated";
		}
		
		
		return "createTask";
	}

}
