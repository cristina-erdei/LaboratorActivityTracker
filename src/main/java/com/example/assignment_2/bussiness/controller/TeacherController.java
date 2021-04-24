package com.example.assignment_2.bussiness.controller;

import com.example.assignment_2.bussiness.model.DTO.TeacherDTO;
import com.example.assignment_2.bussiness.model.base.Teacher;
import com.example.assignment_2.bussiness.model.create.TeacherCreateModel;
import com.example.assignment_2.bussiness.service.implementation.TeacherServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teacher")
public class TeacherController {


    @Autowired
    private TeacherServiceImplementation teacherService;

    @GetMapping("/getAll")
    public ResponseEntity<List<TeacherDTO>> findAll() {
        List<Teacher> teachers = teacherService.findAll();

        if (teachers == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(teachers.stream().map(TeacherDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/getByAuthenticationToken/{authenticationToken}")
    public ResponseEntity<TeacherDTO> findByAuthenticationToken(@PathVariable String authenticationToken) {
        Teacher found = teacherService.findByAuthenticationToken(authenticationToken);
        if (found == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new TeacherDTO(found), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<TeacherDTO> findById(@PathVariable Long id) {
        Teacher found = teacherService.findById(id);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new TeacherDTO(found), HttpStatus.OK);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<TeacherDTO> findByEmail(@PathVariable String email) {
        Teacher found = teacherService.findByEmail(email);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new TeacherDTO(found), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TeacherDTO> create(@RequestBody TeacherCreateModel createModel) {
        Teacher saved = teacherService.create(createModel);

        return new ResponseEntity<>(new TeacherDTO(saved), HttpStatus.OK);
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<TeacherDTO> update(@PathVariable Long id, @RequestBody TeacherCreateModel createModel) {
        Teacher updated = teacherService.update(id, createModel);

        if(updated == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new TeacherDTO(updated), HttpStatus.OK);
    }

    @PostMapping("/updateAuthenticationToken/{id}")
    public ResponseEntity updateAuthenticationToken(@PathVariable Long id, @RequestBody String token) {
        boolean success = teacherService.updateAuthenticationToken(id, token);
        if(!success){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<TeacherDTO> deleteById(@PathVariable Long id) {
        Teacher deleted = teacherService.deleteById(id);

        if(deleted == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new TeacherDTO(deleted), HttpStatus.OK);
    }
}
