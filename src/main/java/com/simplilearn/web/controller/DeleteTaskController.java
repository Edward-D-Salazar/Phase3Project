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
import com.simplilearn.web.service.DeleteTaskService;

@Controller
public class DeleteTaskController {
	
	@Autowired
	DeleteTaskService service;
	
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	public String showDeleteTask(ModelMap model) {
		
		logger.info("Inside Delete Task");
		model.addAttribute("deleteTask", new TaskEntity());
		return "deleteTask";
		
	}
	
	@RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
	public String processUpdateTask(@ModelAttribute("deleteTask") TaskEntity deleteTask, ModelMap model) {
		logger.info("Inside processCreatTask");
		if (!deleteTask.equals(null) && deleteTask.getId() != null) {
			service.deleteTask(deleteTask);
			return "taskDeleted";
		}

		return "taskDeleteFailed";
	}

}
