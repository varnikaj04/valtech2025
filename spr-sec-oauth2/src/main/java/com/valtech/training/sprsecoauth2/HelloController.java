package com.valtech.training.sprsecoauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String hello(String hello) {
		return "Hello";
	}
	
}
