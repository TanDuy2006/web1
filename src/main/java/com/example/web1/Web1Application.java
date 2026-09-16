package com.example.web1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestHeader;
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
	// Bài 4A: Trả về 1 JSON Object (1 sinh viên)
    @GetMapping("/students")
    public Student getStudent() {
        return new Student(1, "Nguyễn Văn A", 20);
    }

    // Bài 4B: Trả về 1 JSON Array (Danh sách sinh viên)
    @GetMapping("/studenttall")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "A", 20));
        list.add(new Student(2, "B", 21));
        return list;
    }
	// Bài 5: Lấy dữ liệu Header "Authorization"
    @GetMapping("/getstudent")
    public String getStudentsHeader(@RequestHeader("Authorization") String inputstring) {
        return "Authorization = " + inputstring;
    }
}