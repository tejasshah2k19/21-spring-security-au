package com.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.UserBean;
import com.repository.UserRepository;

@Controller
@RequestMapping("/public")
public class SessionController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BCryptPasswordEncoder bcrypt;

	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/authenticate")
	public String authenticate() {
		return "";
	}

	@PostMapping("/saveuser")
	public String saveUser(UserBean user) {//plain text password 
		System.out.println(user.getUsername());
		System.out.println("before => ");
		System.out.println(user.getPassword());
		user.setPassword(bcrypt.encode(user.getPassword())); // royal -->324m23kj45hk454h45
		
		System.out.println("After => ");
		System.out.println(user.getPassword()); //324m23kj45hk454h45
		
		user.setRole("ROLE_USER");//
		userRepo.save(user);//
		return "redirect:/login";
	}
}



















