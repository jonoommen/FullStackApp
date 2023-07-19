package com.codewitharjun.fullstackbackend.service;

import com.codewitharjun.fullstackbackend.exception.StudentNotFoundException;
import com.codewitharjun.fullstackbackend.model.Student;
import com.codewitharjun.fullstackbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student add(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public Student updateStudent(Student newStudent, Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setUsername(newStudent.getUsername());
                    student.setName(newStudent.getName());
                    student.setAddress(newStudent.getAddress());
                    student.setCity(newStudent.getCity());
                    return studentRepository.save(student);
                }).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public String deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
        return  "Student with id "+id+" has been deleted success.";
    }
}
