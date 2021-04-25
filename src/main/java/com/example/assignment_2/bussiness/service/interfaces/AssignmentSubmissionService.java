package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.base.AssignmentSubmission;
import com.example.assignment_2.bussiness.model.create.AssignmentSubmissionCreateModel;
import com.example.assignment_2.bussiness.model.create.Grade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssignmentSubmissionService {
    List<AssignmentSubmission> findAll();

    AssignmentSubmission findById(Long id);

    List<AssignmentSubmission> findAllByAssignment_Id(Long assignment_Id);

    AssignmentSubmission create(AssignmentSubmissionCreateModel createModel);

    AssignmentSubmission update(Long id, AssignmentSubmissionCreateModel newValue);

    AssignmentSubmission deleteById(Long id);

    AssignmentSubmission grade(Long id, Grade grade);
}
