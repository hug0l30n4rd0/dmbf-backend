package com.dmbf.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmbf.model.ApplicationUser;
import com.dmbf.persistence.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
	 private UserRepository applicationUserRepository;
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    public AuthController(UserRepository applicationUserRepository,
	                          BCryptPasswordEncoder bCryptPasswordEncoder) {
	        this.applicationUserRepository = applicationUserRepository;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }

	    @PostMapping("/sign-up")
	    public void signUp(@RequestBody ApplicationUser user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        applicationUserRepository.save(user);
	    }
}
