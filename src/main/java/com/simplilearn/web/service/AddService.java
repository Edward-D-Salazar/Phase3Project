package com.simplilearn.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.web.controller.SearchController;
import com.simplilearn.web.model.UserEntity;
import com.simplilearn.web.model.UserEntityCrudRepository;

@Service
public class AddService {
	
	@Autowired
	UserEntityCrudRepository userEntityCrudRepository;
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	public boolean addUser(UserEntity user) {
		logger.info("Inside addUser fileName = EditService.java");
		
		if (user == null || user.getFirstName() == null) {
            throw new RuntimeException("First Name required");
        }
		if (user == null || user.getLastName() == null) {
            throw new RuntimeException("Last Name required");
        }
		if (user == null || user.getUsername() == null) {
            throw new RuntimeException("Username required");
        }
        if (user == null || user.getPassword() == null) {
            throw new RuntimeException("Password required");
        }
        
        userEntityCrudRepository.save(user);
		return true;
	}

}
