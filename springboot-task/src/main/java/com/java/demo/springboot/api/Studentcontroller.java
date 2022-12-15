package com.java.demo.springboot.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.java.demo.springboot.dto.StudentDto;

import com.java.demo.springboot.svc.StudentService;


@RestController
@RequestMapping("/api/students")
public class Studentcontroller {
    private StudentService studentService;
    

    public Studentcontroller(StudentService studentService) {
        this.studentService = studentService;
       
    }
    @PostMapping()
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto)
    {
     return new ResponseEntity<>(studentService.createStudent(studentDto),HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<StudentDto> getAllStudents(){
      return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name="id") long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }
    
     @GetMapping("/courses")
     public ResponseEntity<StudentDto>getMaxStudent(){
         return new ResponseEntity<>(studentService.getMaxStudent(),HttpStatus.OK);
     }
  
     }


   


