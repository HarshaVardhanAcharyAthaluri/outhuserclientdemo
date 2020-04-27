package com.harsha.outhuserclientdemo.controllers;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	 @GetMapping("/")
	    public String index(@AuthenticationPrincipal Jwt jwt) {
	        return String.format("Hello, %s!", jwt.getSubject());
	    }

	@GetMapping("/read")
	public String read(Principal principal) {
	    return "Hello write: " + principal.getName();
	}
	 
	@GetMapping("/write")
	public String write(Principal principal) {
	    return "Hello write: " + principal.getName();
	}
	
}
