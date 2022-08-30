package com.day11.unittestingspring.controller;

import com.day11.unittestingspring.model.Student;
import com.day11.unittestingspring.repository.StudentRepositiry;
import com.day11.unittestingspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/{firstname}")
    public Optional<Student> getStudentByFirstName(@PathVariable String firstname){
        return studentService.getStudentByFirstName(firstname);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Student> createStudent (@RequestBody List<Student> student){
        return studentService.createStudent(student);
    }

}
