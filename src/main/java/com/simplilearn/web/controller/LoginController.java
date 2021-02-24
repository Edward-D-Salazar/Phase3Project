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
import com.simplilearn.web.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String showUserLogin(ModelMap model) {
		logger.info("Inside login User");
		model.addAttribute("userLogin", new UserEntity());
		return "userLogin";
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("userLogin") UserEntity loginUser, ModelMap model) {
		logger.info("Inside processLogin fileName = LoginController.java");
		if (!loginUser.equals(null) && loginUser.getUsername() != "" && loginUser.getPassword() != "") {
			if(service.loginUser(loginUser)) {
			return "loginSuccessful";
			}
		}

		logger.warn("BLANK TEXTFIELD DETECTED");
		model.addAttribute("add", "Please fill up all the field");
		return "loginFailed";

	}
	
	

}
