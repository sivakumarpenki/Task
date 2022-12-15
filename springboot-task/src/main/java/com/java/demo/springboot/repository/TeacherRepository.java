package com.java.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.demo.springboot.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    
}
