package com.example.assignment_2.data.repository;

import com.example.assignment_2.data.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDB, Long> {
    StudentDB findByAuthenticationToken(String token);
    StudentDB findByEmail(String email);
}


