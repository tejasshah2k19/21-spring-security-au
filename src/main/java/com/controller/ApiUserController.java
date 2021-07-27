package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;

@RequestMapping("/users")
@RestController
public class ApiUserController {

	ArrayList<UserBean> users = new ArrayList<>();

	public ApiUserController() {
		UserBean u1 = new UserBean();
		u1.setEmail("a@a.com");
		u1.setPassword("aaa");
		u1.setRole("USER");
		users.add(u1);
	}

	@GetMapping("/myusers")
	public ArrayList<UserBean> getAllUsers() {
		return users;
	}

}
