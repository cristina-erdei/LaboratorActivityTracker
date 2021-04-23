package com.example.assignment_2.data.repository;

import com.example.assignment_2.data.model.AttendanceDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceDB, Long> {
}
