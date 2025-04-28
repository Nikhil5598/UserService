package com.userService.services;

import com.userService.entity.User;

public interface UserServices {

	User saveUser(User user);

	String checkPassword(User user) throws Exception;

	

}
