package com.day11.unittestingspring.service;

import com.day11.unittestingspring.model.Student;
import com.day11.unittestingspring.repository.StudentRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private final StudentRepositiry studentRepositiry;

    public StudentServiceImp(StudentRepositiry studentRepositiry) {
        this.studentRepositiry = studentRepositiry;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepositiry.findAll();
    }

    @Override
    public List<Student> createStudent(List<Student> student) {
        return studentRepositiry.saveAll(student);
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepositiry.findById(id);
    }

    @Override
    public Optional<Student> getStudentByFirstName(String firstname) {
        return studentRepositiry.findByFirstName(firstname);
    }
}
