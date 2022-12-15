package com.java.demo.springboot.svc;

import java.util.List;

import com.java.demo.springboot.dto.CourseDto;
import com.java.demo.springboot.entity.Course;



public interface CourseService {


    Course createCourse(CourseDto courseDto);

    List<CourseDto> getAllCourses();

    CourseDto createTeacher(long teacherId, CourseDto courseDto);

   



    
    
}
