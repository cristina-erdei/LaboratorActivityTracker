package com.example.assignment_2.bussiness.controller;

import com.example.assignment_2.bussiness.model.DTO.AttendanceDTO;
import com.example.assignment_2.bussiness.model.DTO.LaboratoryDTO;
import com.example.assignment_2.bussiness.model.base.Attendance;
import com.example.assignment_2.bussiness.model.base.Laboratory;
import com.example.assignment_2.bussiness.model.create.AttendanceCreateModel;
import com.example.assignment_2.bussiness.service.implementation.AttendanceServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {


    @Autowired
    private AttendanceServiceImplementation attendanceService;

    public ResponseEntity<List<AttendanceDTO>> findAll() {
        List<Attendance> attendances = attendanceService.findAll();

        if (attendances == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(attendances.stream().map(AttendanceDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<AttendanceDTO> findById(Long id) {
        Attendance found = attendanceService.findById(id);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AttendanceDTO(found), HttpStatus.OK);
    }

    public ResponseEntity<List<AttendanceDTO>> findAllByLaboratory_Id(Long laboratory_id) {
        List<Attendance> attendances = attendanceService.findAllByLaboratory_Id(laboratory_id);

        if(attendances == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(attendances.stream().map(AttendanceDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<AttendanceDTO> create(AttendanceCreateModel createModel) {
        Attendance saved = attendanceService.create(createModel);

        return new ResponseEntity<>(new AttendanceDTO(saved), HttpStatus.OK);
    }

    public ResponseEntity<AttendanceDTO> update(Long id, AttendanceCreateModel newValue) {
        Attendance updated = attendanceService.update(id, newValue);

        if(updated == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AttendanceDTO(updated), HttpStatus.OK);
    }

    public ResponseEntity<AttendanceDTO> deleteById(Long id) {
        Attendance deleted = attendanceService.deleteById(id);

        if(deleted == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AttendanceDTO(deleted), HttpStatus.OK);
    }
}
