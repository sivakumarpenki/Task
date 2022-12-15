package com.java.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.demo.springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    
}
