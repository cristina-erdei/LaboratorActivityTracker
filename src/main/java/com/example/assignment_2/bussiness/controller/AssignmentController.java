package com.example.assignment_2.bussiness.controller;

import com.example.assignment_2.bussiness.model.DTO.AssignmentDTO;
import com.example.assignment_2.bussiness.model.DTO.AttendanceDTO;
import com.example.assignment_2.bussiness.model.base.Assignment;
import com.example.assignment_2.bussiness.model.base.Attendance;
import com.example.assignment_2.bussiness.model.create.AssignmentCreateModel;
import com.example.assignment_2.bussiness.service.implementation.AssignmentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {


    @Autowired
    private AssignmentServiceImplementation assignmentService;

    public ResponseEntity<List<AssignmentDTO>> findAll() {
        List<Assignment> assignments = assignmentService.findAll();

        if (assignments == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(assignments.stream().map(AssignmentDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<AssignmentDTO> findById(Long id) {
        Assignment found = assignmentService.findById(id);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentDTO(found), HttpStatus.OK);
    }

    public ResponseEntity<List<AssignmentDTO>> findAllByLaboratory_Id(Long laboratory_id) {
        List<Assignment> attendances = assignmentService.findAllByLaboratory_Id(laboratory_id);

        if(attendances == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(attendances.stream().map(AssignmentDTO::new).collect(Collectors.toList()), HttpStatus.OK);

    }

    public ResponseEntity<AssignmentDTO> create(AssignmentCreateModel createModel) {
        Assignment saved = assignmentService.create(createModel);

        return new ResponseEntity<>(new AssignmentDTO(saved), HttpStatus.OK);

    }

    public ResponseEntity<AssignmentDTO> update(Long id, AssignmentCreateModel newValue) {
        Assignment updated = assignmentService.update(id, newValue);

        if(updated == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentDTO(updated), HttpStatus.OK);

    }

    public ResponseEntity<AssignmentDTO> deleteById(Long id) {
        Assignment deleted = assignmentService.deleteById(id);

        if(deleted == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AssignmentDTO(deleted), HttpStatus.OK);

    }
}
