package com.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController            //use for Rest API
//@RequestMapping("/home")
@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/user")
	public String userPage() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		return "admin";
	}
	
	@GetMapping("/signin")
	public String signinPage() {
		return "signin";
	}
	
	@GetMapping("/success")
	public String successPage() {
		return "success";
	}
	
	
//	@GetMapping("/user")
//	public ResponseEntity<String> user(){
//		return ResponseEntity.ok("my role is ROLE_USER");
//	}
//	
//	@GetMapping("/admin")
//	public ResponseEntity<String> admin(){
//		return ResponseEntity.ok("My role is ROLE_ADMIN");
//	}
	
}
