package com.java.demo.springboot.svc.impl;



import java.util.LinkedList;
import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.java.demo.springboot.dto.StudentDto;
import com.java.demo.springboot.entity.Course;
import com.java.demo.springboot.entity.Student;
import com.java.demo.springboot.exception.ResourceNotFoundException;
import com.java.demo.springboot.repository.CourseRepository;
import com.java.demo.springboot.repository.StudentRepository;
import com.java.demo.springboot.svc.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private ModelMapper mapper;
    

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.courseRepository=courseRepository;
        this.mapper=mapper;
    }


    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        //convert dto to entity
        Student student=mapToEntity(studentDto);
    
        Student newStudent=studentRepository.save(student);

        //convert entity to dto
        StudentDto studentResponse= mapToDto(newStudent);

        return studentResponse;
    }
      @Override
      public List<StudentDto> getAllStudents() {
      List<Student> students= studentRepository.findAll();
        return students.stream().map(student->mapToDto(student)).collect(Collectors.toList());
           
    }
    // convert entity to DTO
    private StudentDto mapToDto(Student student){
        StudentDto studentDto=mapper.map(student, StudentDto.class);

        List<Long> courseIds= new LinkedList<>();
        for(Course course:student.getCourse()){
            courseIds.add(course.getId());
        }
        
        studentDto.setCourseIds(courseIds);
        return studentDto;
    
    }
    //convert Dto  to entity
    private Student  mapToEntity(StudentDto studentDto){
        Student student= mapper.map(studentDto, Student.class);

        if(!studentDto.getCourseIds().isEmpty()){

            List<Course> listCourses = courseRepository.findAllById(studentDto.getCourseIds());
            
            Set<Course> setCourses = listCourses.stream().collect(Collectors.toSet());
            student.setCourse(setCourses);
        }
       
        return student;

    }


    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student", "id", id));
        return mapToDto(student);
    }


    @Override
    public StudentDto getMaxStudent() {
         List<Student> maxStudent= studentRepository.findAll();
         Student student = maxStudent.stream().max((i1,i2)->i1.getCourse().size()-i2.getCourse().size()).get();
         return mapToDto(student);
     
    }

        
    }



    


    
    




   
    

