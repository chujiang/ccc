package com.kingnod.etraining.organization.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.service.UserService;

@org.springframework.stereotype.Component()
public class UserInfoFactory {
	
	@Autowired(required=true)
	private UserService userService;
	
	public User getUserInfo(Long id){
		userService.getUser(id);
		return new User();
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
