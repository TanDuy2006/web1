package com.example.web1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/student/{id}")
	public String getStudent(@PathVariable String id) {
		return "Student ID: " + id;
	}
	@GetMapping ("/greet")
	public String greet(@RequestParam String name) {
		return "Hello, " + name + "!";	
	}
	@GetMapping("/searchstudent")
	public String searchStudent(
		@RequestParam String name,
		@RequestParam(defaultValue = "1") int age) {
		return "Searching for student: " + name + ", Age: " + age;
	}
}