package com.example.assignment_2.bussiness.controller;

import com.example.assignment_2.bussiness.model.DTO.AssignmentSubmissionDTO;
import com.example.assignment_2.bussiness.model.base.AssignmentSubmission;
import com.example.assignment_2.bussiness.model.create.AssignmentSubmissionCreateModel;
import com.example.assignment_2.bussiness.model.create.Grade;
import com.example.assignment_2.bussiness.service.implementation.AssignmentSubmissionServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("submission")
public class AssignmentSubmissionController {


    @Autowired
    private AssignmentSubmissionServiceImplementation assignmentSubmissionService;

    public ResponseEntity<List<AssignmentSubmissionDTO>> findAll() {
        List<AssignmentSubmission> assignmentSubmissions = assignmentSubmissionService.findAll();

        if (assignmentSubmissions == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(assignmentSubmissions.stream().map(AssignmentSubmissionDTO::new).collect(Collectors.toList()), HttpStatus.OK);

    }

    public ResponseEntity<AssignmentSubmissionDTO> findById(Long id) {
        AssignmentSubmission found = assignmentSubmissionService.findById(id);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentSubmissionDTO(found), HttpStatus.OK);

    }

    public ResponseEntity<List<AssignmentSubmissionDTO>> findAllByAssignment_Id(Long assignment_Id) {
        List<AssignmentSubmission> assignmentSubmissions = assignmentSubmissionService.findAllByAssignment_Id(assignment_Id);
        if (assignmentSubmissions == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(assignmentSubmissions.stream().map(AssignmentSubmissionDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<AssignmentSubmissionDTO> create(AssignmentSubmissionCreateModel createModel) {
        AssignmentSubmission saved = assignmentSubmissionService.create(createModel);

        return new ResponseEntity<>(new AssignmentSubmissionDTO(saved), HttpStatus.OK);

    }

    public ResponseEntity<AssignmentSubmissionDTO> update(Long id, AssignmentSubmissionCreateModel newValue) {
        AssignmentSubmission updated = assignmentSubmissionService.update(id, newValue);

        if(updated == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentSubmissionDTO(updated), HttpStatus.OK);

    }

    public ResponseEntity<AssignmentSubmissionDTO> deleteById(Long id) {
        AssignmentSubmission deleted = assignmentSubmissionService.deleteById(id);

        if(deleted == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentSubmissionDTO(deleted), HttpStatus.OK);

    }

    public ResponseEntity<AssignmentSubmissionDTO> grade(Long id, Grade grade) {
        AssignmentSubmission graded = assignmentSubmissionService.grade(id, grade);
        if(graded == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentSubmissionDTO(graded), HttpStatus.OK);


    }
}
