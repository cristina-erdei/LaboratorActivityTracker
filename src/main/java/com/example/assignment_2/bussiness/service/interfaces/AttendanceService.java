package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.DTO.AttendanceDTO;
import com.example.assignment_2.bussiness.model.base.Attendance;
import com.example.assignment_2.bussiness.model.create.AttendanceCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendanceService {
    List<Attendance> findAll();

    Attendance findById(Long id);

    List<Attendance> findAllByLaboratory(Long id);

    Attendance create(AttendanceCreateModel createModel);

    void deleteById(Long id);

}
