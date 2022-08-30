package com.day11.unittestingspring.repository;

import com.day11.unittestingspring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepositiry extends JpaRepository<Student,Long> {

    Optional<Student> findByFirstName(String firstname);
}
