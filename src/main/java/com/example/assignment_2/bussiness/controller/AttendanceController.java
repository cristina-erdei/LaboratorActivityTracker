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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {


    @Autowired
    private AttendanceServiceImplementation attendanceService;

    @GetMapping("/getAll")
    public ResponseEntity<List<AttendanceDTO>> findAll() {
        List<Attendance> attendances = attendanceService.findAll();

        if (attendances == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(attendances.stream().map(AttendanceDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AttendanceDTO> findById(@PathVariable Long id) {
        Attendance found = attendanceService.findById(id);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AttendanceDTO(found), HttpStatus.OK);
    }

    @GetMapping("/getByLaboratoryId/{laboratory_id}")
    public ResponseEntity<List<AttendanceDTO>> findAllByLaboratory_Id(@PathVariable Long laboratory_id) {
        List<Attendance> attendances = attendanceService.findAllByLaboratory_Id(laboratory_id);

        if(attendances == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(attendances.stream().map(AttendanceDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AttendanceDTO> create(@RequestBody AttendanceCreateModel createModel) {
        Attendance saved = attendanceService.create(createModel);

        return new ResponseEntity<>(new AttendanceDTO(saved), HttpStatus.OK);
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<AttendanceDTO> update(@PathVariable Long id, @RequestBody AttendanceCreateModel newValue) {
        Attendance updated = attendanceService.update(id, newValue);

        if(updated == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AttendanceDTO(updated), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<AttendanceDTO> deleteById(@PathVariable Long id) {
        Attendance deleted = attendanceService.deleteById(id);

        if(deleted == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AttendanceDTO(deleted), HttpStatus.OK);
    }
}
