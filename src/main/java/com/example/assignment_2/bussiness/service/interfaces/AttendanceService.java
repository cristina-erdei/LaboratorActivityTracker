package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.base.Attendance;
import com.example.assignment_2.bussiness.model.create.AttendanceCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendanceService {
    List<Attendance> findAll();

    Attendance findById(Long id);

    List<Attendance> findAllByLaboratory_Id(Long laboratory_id);

    Attendance create(AttendanceCreateModel createModel);

    Attendance update(Long id, AttendanceCreateModel newValue);

    Attendance deleteById(Long id);

}
