package com.example.web1;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Lấy tất cả sinh viên
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Lấy sinh viên theo ID
    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Thêm mới sinh viên
    public Student createStudent(Student student) {
        student.setId(null); // Đảm bảo ID được sinh tự động
        return studentRepository.save(student);
    }

    // Cập nhật thông tin sinh viên
    public Student updateStudent(UUID id, Student studentDetails) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setStudentCode(studentDetails.getStudentCode());
            existingStudent.setFullName(studentDetails.getFullName());
            existingStudent.setEmail(studentDetails.getEmail());
            existingStudent.setPhone(studentDetails.getPhone());
            existingStudent.setClassName(studentDetails.getClassName());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    // Xóa sinh viên
    public boolean deleteStudent(UUID id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Tìm kiếm sinh viên theo từ khóa
    public List<Student> searchStudents(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return studentRepository.findAll();
        }
        return studentRepository
                .findByStudentCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingIgnoreCase(
                        keyword, keyword, keyword, keyword);
    }
}