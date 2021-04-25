package com.example.assignment_2.data.repository;

import com.example.assignment_2.data.model.AttendanceDB;
import com.example.assignment_2.data.model.LaboratoryDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceDB, Long> {
    List<AttendanceDB> findAllByLaboratory_Id(Long laboratory_id);
}
