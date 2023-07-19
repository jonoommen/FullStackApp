package com.codewitharjun.fullstackbackend.repository;

import com.codewitharjun.fullstackbackend.model.Student;
import com.codewitharjun.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByName(String name);
}
