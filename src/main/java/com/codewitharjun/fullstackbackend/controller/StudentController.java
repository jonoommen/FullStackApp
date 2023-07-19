package com.codewitharjun.fullstackbackend.controller;

import com.codewitharjun.fullstackbackend.model.Student;
import com.codewitharjun.fullstackbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Created by Arjun Gautam */
@RestController
@CrossOrigin("http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    Student newStudent(@RequestBody Student newStudent) {
        return studentService.add(newStudent);
    }

    @GetMapping("/students")
    List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/student/{id}")
    Student updateStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        return studentService.updateStudent(newStudent, id);
    }

    @DeleteMapping("/student/{id}")
    String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }



}
