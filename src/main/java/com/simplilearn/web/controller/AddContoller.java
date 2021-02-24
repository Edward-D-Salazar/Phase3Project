package com.simplilearn.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplilearn.web.model.UserEntity;
import com.simplilearn.web.service.AddService;

@Controller
public class AddContoller {
	
	@Autowired
	AddService service;
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping(value = "/userAdd", method = RequestMethod.GET)
	public String showUserAdd(ModelMap model) {
		logger.info("Inside add User");
		model.addAttribute("userAdd", new UserEntity());
		return "userAdd";
	}
	
	@RequestMapping(value = "/userAdd", method = RequestMethod.POST)
	public String processAdd(@ModelAttribute("userAdd") UserEntity addUser, ModelMap model) {
		logger.info("Inside processAdding fileName = AddController.java");
		if (!addUser.equals(null) && addUser.getUsername() != "" && addUser.getPassword() != ""
				&& addUser.getFirstName() != "" && addUser.getLastName() != "") {
			service.addUser(addUser);
			return "userAdded";
		}

		logger.warn("BLANK TEXTFIELD DETECTED");
		model.addAttribute("add", "Please fill up all the field");
		return "userAdd";

	}

}
