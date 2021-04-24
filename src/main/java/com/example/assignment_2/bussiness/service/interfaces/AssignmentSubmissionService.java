package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.DTO.AssignmentSubmissionDTO;
import com.example.assignment_2.bussiness.model.base.AssignmentSubmission;
import com.example.assignment_2.bussiness.model.create.AssignmentSubmissionCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssignmentSubmissionService {
    List<AssignmentSubmission> findAll();

    AssignmentSubmission findById(Long id);

    List<AssignmentSubmission> findAllByAssignment(Long assignmentId);

    AssignmentSubmission create(AssignmentSubmissionCreateModel createModel);

    void deleteById(Long id);

    void grade(int grade);
}
