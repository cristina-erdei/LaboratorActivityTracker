package com.example.assignment_2.data.repository;

import com.example.assignment_2.data.model.AssignmentDB;
import com.example.assignment_2.data.model.LaboratoryDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentDB, Long> {
    List<AssignmentDB> findAllByLaboratory(LaboratoryDB laboratory);
}
