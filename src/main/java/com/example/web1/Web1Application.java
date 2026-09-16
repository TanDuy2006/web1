package com.example.web1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/api")
@SpringBootApplication
public class Web1Application {

	public static void main(String[] args) {
		SpringApplication.run(Web1Application.class, args);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}
	@GetMapping ("/student/{id}")
	public String getStudent(@PathVariable String id) {
		return "Sinh viên có mã: " + id;
	}
}
