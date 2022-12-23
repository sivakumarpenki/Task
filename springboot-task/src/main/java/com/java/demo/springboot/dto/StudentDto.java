package com.java.demo.springboot.dto;

import java.time.LocalDate;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private List<Long> courseIds;
   
    }
   
    

