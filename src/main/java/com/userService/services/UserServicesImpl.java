package com.userService.services;


import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userService.entity.User;
import com.userService.repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	private Logger logger=LoggerFactory.getLogger(UserServices.class);



	@Override
	public User saveUser(User user) {
		
		
	    try {
			String password= EncryptionService.encrypt(user.getPassword());
			user.setPassword(password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
		return userRepository.save(user);
	}



	



	
	public String checkPassword(User user) throws Exception {
		String username=user.getUsername();
		String password=user.getPassword();
		
        User userr = userRepository.findByUsername(username);
        if (userr == null) return "username is null";

        String decryptedpassword = EncryptionService.decrypt(userr.getPassword());
        if(Objects.equals(decryptedpassword, password)) {
        	return "Welcome to CafeService";
        }
        return "please check your password";
    }
	
	
   

    
}
