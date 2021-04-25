package com.example.assignment_2.bussiness.controller;

import com.example.assignment_2.bussiness.model.DTO.AssignmentSubmissionDTO;
import com.example.assignment_2.bussiness.model.base.AssignmentSubmission;
import com.example.assignment_2.bussiness.model.create.AssignmentSubmissionCreateModel;
import com.example.assignment_2.bussiness.model.create.Grade;
import com.example.assignment_2.bussiness.service.implementation.AssignmentSubmissionServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("submission")
public class AssignmentSubmissionController {


    @Autowired
    private AssignmentSubmissionServiceImplementation assignmentSubmissionService;

    @GetMapping("/getAll")
    public ResponseEntity<List<AssignmentSubmissionDTO>> findAll() {
        List<AssignmentSubmission> assignmentSubmissions = assignmentSubmissionService.findAll();

        if (assignmentSubmissions == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(assignmentSubmissions.stream().map(AssignmentSubmissionDTO::new).collect(Collectors.toList()), HttpStatus.OK);

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AssignmentSubmissionDTO> findById(@PathVariable Long id) {
        AssignmentSubmission found = assignmentSubmissionService.findById(id);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentSubmissionDTO(found), HttpStatus.OK);

    }

    @GetMapping("/getByAssignmentId/{assignment_Id}")
    public ResponseEntity<List<AssignmentSubmissionDTO>> findAllByAssignment_Id(@PathVariable Long assignment_Id) {
        List<AssignmentSubmission> assignmentSubmissions = assignmentSubmissionService.findAllByAssignment_Id(assignment_Id);
        if (assignmentSubmissions == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(assignmentSubmissions.stream().map(AssignmentSubmissionDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AssignmentSubmissionDTO> create(@RequestBody AssignmentSubmissionCreateModel createModel) {
        AssignmentSubmission saved = assignmentSubmissionService.create(createModel);

        return new ResponseEntity<>(new AssignmentSubmissionDTO(saved), HttpStatus.OK);

    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<AssignmentSubmissionDTO> update(@PathVariable Long id, @RequestBody AssignmentSubmissionCreateModel newValue) {
        AssignmentSubmission updated = assignmentSubmissionService.update(id, newValue);

        if(updated == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentSubmissionDTO(updated), HttpStatus.OK);

    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<AssignmentSubmissionDTO> deleteById(@PathVariable Long id) {
        AssignmentSubmission deleted = assignmentSubmissionService.deleteById(id);

        if(deleted == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentSubmissionDTO(deleted), HttpStatus.OK);

    }

    @PostMapping("/grade/{id}")
    public ResponseEntity<AssignmentSubmissionDTO> grade(@PathVariable Long id, @RequestBody Grade grade) {
        AssignmentSubmission graded = assignmentSubmissionService.grade(id, grade);
        if(graded == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentSubmissionDTO(graded), HttpStatus.OK);


    }
}
