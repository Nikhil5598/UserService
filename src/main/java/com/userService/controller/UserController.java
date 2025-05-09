package com.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userService.entity.User;
import com.userService.services.UserServices;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/registration")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userServices.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@PostMapping("/login")
	public String getSingleUser(@RequestBody User user) throws Exception {
		return userServices.checkPassword(user);
	}

	
	
}
