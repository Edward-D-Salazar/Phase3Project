package com.simplilearn.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.simplilearn.web.controller.SearchController;
import com.simplilearn.web.model.UserEntity;
import com.simplilearn.web.model.UserEntityCrudRepository;

@Service
public class LoginService {

	@Autowired
	UserEntityCrudRepository userEntityCrudRepository;
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);

	public boolean loginUser(@ModelAttribute UserEntity user) {
		logger.info("Inside loginUser fileName = LoginService.java");

		

		Iterable<UserEntity> users = userEntityCrudRepository.findAll();

		for (UserEntity loginEntity : users) {
			if (loginEntity.getUsername().equals(user.getUsername())
					&& loginEntity.getPassword().equals(user.getPassword())) {
				return true;
			}
		}

		return false;

	}

}
