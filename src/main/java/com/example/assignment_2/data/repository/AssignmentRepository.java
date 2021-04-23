package com.example.assignment_2.data.repository;

import com.example.assignment_2.data.model.AssignmentDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentDB, Long> {
}
