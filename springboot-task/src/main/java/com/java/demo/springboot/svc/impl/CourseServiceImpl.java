package com.java.demo.springboot.svc.impl;



import java.util.List;

import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.java.demo.springboot.dto.CourseDto;

import com.java.demo.springboot.entity.Course;

import com.java.demo.springboot.entity.Teacher;
import com.java.demo.springboot.exception.ResourceNotFoundException;
import com.java.demo.springboot.repository.CourseRepository;
import com.java.demo.springboot.repository.StudentRepository;
import com.java.demo.springboot.repository.TeacherRepository;
import com.java.demo.springboot.svc.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository=studentRepository;
        this.teacherRepository=teacherRepository;
    }    
    @Override 
    public CourseDto createCourse(CourseDto courseDto) {
        Course course=mapToEntity(courseDto);
        Course newCourse=courseRepository.save(course);

        CourseDto courseResponse= mapToDto(newCourse);
        return courseResponse;
    }
    

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses= courseRepository.findAll();
        return courses.stream().map(course-> mapToDto(course)).collect(Collectors.toList());
    
    }
    
    
    private CourseDto mapToDto(Course course){
        CourseDto courseDto= new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());

        return courseDto;
    }



    private Course mapToEntity(CourseDto courseDto){
        Course course = new Course();
    
        course.setName(courseDto.getName());

        return course;
    }


    @Override
    public CourseDto createTeacher(long teacherId, CourseDto courseDto) {
       Course course= mapToEntity(courseDto);

       //retrieve teacher by id
       Teacher teacher  =teacherRepository.findById(teacherId).orElseThrow(()->new ResourceNotFoundException("teacher", "id", "id"));

       //set teacher to entity
       course.setTeacher(teacher);

       //course entity to db
       
       Course newCourse= courseRepository.save(course);
        return mapToDto(newCourse);
    }
}






    


   
    


