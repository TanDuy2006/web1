package com.example.web1;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Controller", description = "Quản lý thông tin sinh viên")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Lấy danh sách tất cả sinh viên
    @GetMapping
    @Operation(summary = "Lấy tất cả sinh viên")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // Lấy thông tin 1 sinh viên theo ID
    @GetMapping("/{id}")
    @Operation(summary = "Lấy sinh viên theo ID")
    public ResponseEntity<Student> getStudentById(@PathVariable UUID id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    // Thêm sinh viên mới
    @PostMapping
    @Operation(summary = "Thêm mới sinh viên")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    // Cập nhật thông tin sinh viên
    @PutMapping("/{id}")
    @Operation(summary = "Cập nhật sinh viên theo ID")
    public ResponseEntity<Student> updateStudent(@PathVariable UUID id, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.notFound().build();
    }

    // Xóa sinh viên
    @DeleteMapping("/{id}")
    @Operation(summary = "Xóa sinh viên theo ID")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Tìm kiếm sinh viên theo từ khóa
    @GetMapping("/search")
    @Operation(summary = "Tìm kiếm sinh viên theo từ khóa")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam String keyword) {
        return ResponseEntity.ok(studentService.searchStudents(keyword));
    }
}