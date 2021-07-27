package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.UserBean;

@RequestMapping("/users")
@Controller
public class UserController {

	@GetMapping("/home")
	public String home() {
		System.out.println("home....");
		return "Home";
	}

	@GetMapping("/input")
	public String input() {
		return "Input";
	}

	@PostMapping("/saveuser")
	public String saveUser(UserBean userBean) {
		System.out.println(userBean.getEmail());
		return "Home";
	}
}
