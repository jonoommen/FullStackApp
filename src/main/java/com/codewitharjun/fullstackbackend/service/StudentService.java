package com.codewitharjun.fullstackbackend.service;

import com.codewitharjun.fullstackbackend.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public Student add(Student newStudent);
    public List<Student> getAllStudents();
    public Student getStudentById(Long id);
    public Student updateStudent(Student newStudent, Long id);
    public String deleteStudent(Long id);
}
