package com.java.demo.springboot.entity;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="courses", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",nullable =false)
    private String name;

    @ManyToOne()
    @JoinColumn(name="teacher_id",nullable=true)
    private Teacher teacher;

    @ManyToMany(mappedBy="course")
     private Set<Student> student= new HashSet<>();
    
}
