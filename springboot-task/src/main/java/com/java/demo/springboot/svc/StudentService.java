package com.java.demo.springboot.svc;

import java.util.List;


import com.java.demo.springboot.dto.StudentDto;


public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

   

     List<StudentDto>getAllStudents();

    

    StudentDto getStudentById(long id);

    StudentDto getMaxStudent();
    
}
