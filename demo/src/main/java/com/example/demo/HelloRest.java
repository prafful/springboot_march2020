package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class HelloRest {
	
	
	@RequestMapping(value = "/")
	public String welcome() {
		return "Hello from Spring Boot Again!";
	}
}
