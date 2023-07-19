package com.codewitharjun.fullstackbackend.exception;
/* Created by Arjun Gautam */

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Long id){
        super("Could not find the student with id "+ id);
    }

    public StudentNotFoundException(String name){
        super("Could not find the student with name "+ name);
    }
}