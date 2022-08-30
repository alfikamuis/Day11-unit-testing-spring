package com.day11.unittestingspring.service;

import com.day11.unittestingspring.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();

    List<Student> createStudent(List<Student> student);

    Optional<Student> getStudentById(Long id);

    Optional<Student> getStudentByFirstName(String firstname);
}
