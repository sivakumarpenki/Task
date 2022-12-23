package com.java.demo.springboot.api;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.springboot.dto.CourseDto;
import com.java.demo.springboot.svc.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<CourseDto> getallCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping()
        public ResponseEntity<CourseDto> createCourse( @RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.createCourse(courseDto), HttpStatus.CREATED);
    }

    @PostMapping("/teachers/{teacherId}/courses")
    public ResponseEntity<CourseDto> createTeacher(@PathVariable(value="teacherId") Long teacherId, @RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.createTeacher(teacherId,courseDto),HttpStatus.CREATED);
    }


}
