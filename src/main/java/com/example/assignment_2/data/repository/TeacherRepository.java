package com.example.assignment_2.data.repository;

import com.example.assignment_2.data.model.TeacherDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherDB, Long> {
    TeacherDB findByAuthenticationToken(String token);
    TeacherDB findByEmail(String email);
}
