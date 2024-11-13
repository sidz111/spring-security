package com.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/user")
	public ResponseEntity<String> user(){
		return ResponseEntity.ok("my role is ROLE_USER");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> admin(){
		return ResponseEntity.ok("My role is ROLE_ADMIN");
	}
	
}
