package com.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicApis {

	@GetMapping("/faq")
	public HashMap<String, String> faq() {
		HashMap<String, String> hs = new HashMap<>();
		hs.put("userName", "abcd");
		hs.put("email", "abcd@aa.com");
		return hs;
	}
}
