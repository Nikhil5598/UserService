package com.userService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class UserService {

	public static void main(String[] args) {
		
		SpringApplication.run(UserService.class, args);
		
		   
	}
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
