package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class SessionController {

	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}
}
