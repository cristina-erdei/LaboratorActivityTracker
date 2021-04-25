package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.base.Assignment;
import com.example.assignment_2.bussiness.model.create.AssignmentCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssignmentService {
    List<Assignment> findAll();

    Assignment findById(Long id);

    List<Assignment> findAllByLaboratory_Id(Long laboratory_id);

    Assignment create(AssignmentCreateModel createModel);

    Assignment update(Long id, AssignmentCreateModel newValue);

    Assignment deleteById(Long id);

}
