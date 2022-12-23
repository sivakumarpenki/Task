package com.java.demo.springboot.svc.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.java.demo.springboot.dto.TeacherDto;

import com.java.demo.springboot.entity.Teacher;
import com.java.demo.springboot.repository.TeacherRepository;
import com.java.demo.springboot.svc.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = mapToEntity(teacherDto);
        Teacher newTeacher=teacherRepository.save(teacher);


        TeacherDto teacherResponse= mapToDto(newTeacher);
        return teacherResponse;
    }


    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers= teacherRepository.findAll();
        return teachers.stream().map(teacher->mapToDto(teacher)).collect(Collectors.toList());

    }
    // convert entity to DTO

    private TeacherDto mapToDto(Teacher teacher){
        TeacherDto teacherDto =new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setName(teacher.getName());
        teacherDto.setAge(teacher.getAge());
        return teacherDto;
    }

    //convert DTO to entity

    private Teacher mapToEntity(TeacherDto teacherDto){
        Teacher teacher=new Teacher();
        teacher.setName(teacherDto.getName());
        teacher.setAge(teacherDto.getAge());
        return teacher;
    }
    
}
