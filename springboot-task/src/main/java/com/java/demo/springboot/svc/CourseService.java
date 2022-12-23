package com.java.demo.springboot.svc;

import java.util.List;

import com.java.demo.springboot.dto.CourseDto;




public interface CourseService {


    CourseDto createCourse(CourseDto courseDto);

    List<CourseDto> getAllCourses();

    CourseDto createTeacher(long teacherId, CourseDto courseDto);
    
    
}
