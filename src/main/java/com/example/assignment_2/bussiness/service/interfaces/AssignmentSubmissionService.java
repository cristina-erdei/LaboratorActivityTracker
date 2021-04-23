package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.DTO.AssignmentSubmissionDTO;
import com.example.assignment_2.bussiness.model.create.AssignmentSubmissionCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssignmentSubmissionService {
    List<AssignmentSubmissionDTO> findAll();

    AssignmentSubmissionDTO findById(Long id);

    AssignmentSubmissionDTO create(AssignmentSubmissionCreateModel createModel);

    void deleteById(Long id);


}
