package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.DTO.AttendanceDTO;
import com.example.assignment_2.bussiness.model.create.AttendanceCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendanceService {
    List<AttendanceDTO> findAll();

    AttendanceDTO findById(Long id);

    AttendanceDTO create(AttendanceCreateModel createModel);

    void deleteById(Long id);


}
