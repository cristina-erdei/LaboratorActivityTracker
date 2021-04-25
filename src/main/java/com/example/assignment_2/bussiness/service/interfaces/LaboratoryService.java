package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.base.Attendance;
import com.example.assignment_2.bussiness.model.base.Laboratory;
import com.example.assignment_2.bussiness.model.create.LaboratoryCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LaboratoryService {
    List<Laboratory> findAll();

    Laboratory findById(Long id);

    Laboratory create(LaboratoryCreateModel createModel);

    Laboratory deleteById(Long id);

    Laboratory update(Long id, LaboratoryCreateModel newValue);

    List<Attendance> getAttendance(Long id);
}
