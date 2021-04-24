package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.DTO.AssignmentDTO;
import com.example.assignment_2.bussiness.model.base.Assignment;
import com.example.assignment_2.bussiness.model.create.AssignmentCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssignmentService {
    List<Assignment> findAll();

    Assignment findById(Long id);

    Assignment create(AssignmentCreateModel createModel);

    void deleteById(Long id);


}
