package com.simplilearn.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.web.controller.SearchController;
import com.simplilearn.web.model.UserEntity;
import com.simplilearn.web.model.UserEntityCrudRepository;

@Service
public class SearchService {

	@Autowired
	UserEntityCrudRepository userEntityCrudRepository;
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);

	public boolean searchUser(UserEntity user) {
		logger.info("Inside SearchUser fileName = SearchService.java");
		Long checkId = checkUser(user);
		if (checkId > 0L) {
			logger.warn("DELETING DATA FROM DATABASE WITH ID: " + checkId);
			userEntityCrudRepository.deleteById(checkId);
			return true;
		}
		logger.warn("CANNOT FIND USER IN THE DATABASE");
		return false;
	}

	public Long checkUser(UserEntity user) {
		logger.info("Inside checkUser fileName = SearchService.java");
		Iterable<UserEntity> listOfUsers = userEntityCrudRepository.findAll();
		for (UserEntity userEntity : listOfUsers) {
			if (userEntity.getUsername().equalsIgnoreCase(user.getUsername())) {
				logger.warn("USER FOUND, RETURNING ID OF USER");
				return userEntity.getId();
			}
		}
		return 0L;
	}

}
