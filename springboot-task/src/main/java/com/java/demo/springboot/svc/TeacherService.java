package com.java.demo.springboot.svc;

import java.util.List;

import com.java.demo.springboot.dto.TeacherDto;

public interface TeacherService {
    TeacherDto createTeacher(TeacherDto teacherDto);

    List<TeacherDto> getAllTeachers();


    
}
