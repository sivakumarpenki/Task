package com.java.demo.springboot.entity;

import java.time.LocalDate;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="students", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="gender", nullable = false)
    private String gender;
    @Column(name="dateOfBirth", nullable = false)
    private LocalDate dateOfBirth;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="student_course",joinColumns = @JoinColumn(name="student_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="course_id",referencedColumnName = "id"))
    private Set<Course> course= new HashSet<>();


    
}
