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
import com.simplilearn.web.service.UpdateTaskService;

@Controller
public class UpdateTaskController {
	
	@Autowired
	UpdateTaskService service;

	private static Logger logger = LoggerFactory.getLogger(SearchController.class);

	@RequestMapping(value = "/updateTask", method = RequestMethod.GET)
	public String showUpdateTask(ModelMap model) {
		logger.info("Inside Update Task");
		model.addAttribute("updateTask", new TaskEntity());
		return "updateTask";
	}

	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	public String processUpdateTask(@ModelAttribute("updateTask") TaskEntity updateTask, ModelMap model) {
		logger.info("Inside processCreatTask");
		if (!updateTask.equals(null) && updateTask.getTaskName() != "" && updateTask.getStartDate() != ""
				&& updateTask.getSeverity() != "" && updateTask.getEndDate() != "" && updateTask.getEmail() != ""
				&& updateTask.getDescription() != "") {
			service.updateTask(updateTask);
			return "taskUpdated";
		}

		return "taskUpdateFailed";
	}

}
