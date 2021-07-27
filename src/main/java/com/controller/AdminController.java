package com.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@DeleteMapping("/users")
	public String deleteUser() {
		return "delete user";
	}
	
	@GetMapping("/adminusers")
	public String adminUser() {
		return "admin user";
	}
}
	