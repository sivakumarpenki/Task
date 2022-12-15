package com.java.demo.springboot.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.springboot.dto.TeacherDto;
import com.java.demo.springboot.svc.TeacherService;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping()
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto){
    return new ResponseEntity<>(teacherService.createTeacher(teacherDto), HttpStatus.CREATED);
    }
    @GetMapping()
    public List<TeacherDto> getAllTeachers(){
        return teacherService.getAllTeachers();
    }
    
    
}
