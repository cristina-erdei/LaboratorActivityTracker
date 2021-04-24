package com.example.assignment_2.bussiness.controller;


import com.example.assignment_2.bussiness.model.DTO.StudentDTO;
import com.example.assignment_2.bussiness.model.DTO.TeacherDTO;
import com.example.assignment_2.bussiness.model.base.Student;
import com.example.assignment_2.bussiness.model.base.Teacher;
import com.example.assignment_2.bussiness.model.create.StudentCreateModel;
import com.example.assignment_2.bussiness.service.implementation.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImplementation studentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDTO>> findAll(){
        List<Student> students = studentService.findAll();

        if(students == null){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(students.stream().map(StudentDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id){
        Student found = studentService.findById(id);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new StudentDTO(found), HttpStatus.OK);
    }

    @GetMapping("/getByAuthenticationToken/{token}")
    public ResponseEntity<StudentDTO> findByAuthenticationToken(@PathVariable String token){
        Student found = studentService.findByAuthenticationToken(token);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new StudentDTO(found), HttpStatus.OK);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<StudentDTO> findByEmail(@PathVariable String email){
        Student found = studentService.findByEmail(email);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new StudentDTO(found), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody StudentCreateModel createModel){
        String registrationToken = studentService.create(createModel);
        if(registrationToken == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(registrationToken, HttpStatus.OK);
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Long id, @RequestBody StudentCreateModel newValue){
        Student updated = studentService.update(id, newValue);

        if(updated == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new StudentDTO(updated), HttpStatus.OK);
    }

    @PostMapping("/updateAuthenticationToken/{id}")
    public ResponseEntity
    updateAuthenticationToken(@PathVariable Long id, @RequestBody String token){
        boolean success = studentService.updateAuthenticationToken(id, token);
        if(!success){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/updatePassword/{id}")
    public ResponseEntity updatePassword(@PathVariable Long id, @RequestBody String password){
        boolean success = studentService.updatePassword(id, password);
        if(!success){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);    }


    @PostMapping("/updateRegistered/{id}")
    public ResponseEntity updateRegistered(@PathVariable Long id, @RequestBody boolean registered){
        boolean success = studentService.updateRegistered(id, registered);
        if(!success){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<StudentDTO> deleteById(@PathVariable Long id){
        Student deleted = studentService.deleteById(id);

        if(deleted == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new StudentDTO(deleted), HttpStatus.OK);
    }
}
