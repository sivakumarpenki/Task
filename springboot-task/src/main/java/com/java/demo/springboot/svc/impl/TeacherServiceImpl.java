package com.java.demo.springboot.svc.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.java.demo.springboot.dto.TeacherDto;

import com.java.demo.springboot.entity.Teacher;
import com.java.demo.springboot.repository.TeacherRepository;
import com.java.demo.springboot.svc.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    private ModelMapper mapper;
    

    public TeacherServiceImpl(TeacherRepository teacherRepository, ModelMapper mapper) {
        this.teacherRepository = teacherRepository;
        this.mapper=mapper;
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
        TeacherDto teacherDto=mapper.map(teacher, TeacherDto.class);

        return teacherDto;
    }

    //convert DTO to entity

    private Teacher mapToEntity(TeacherDto teacherDto){
        Teacher teacher =mapper.map(teacherDto, Teacher.class);

        return teacher;
    }
    
}
