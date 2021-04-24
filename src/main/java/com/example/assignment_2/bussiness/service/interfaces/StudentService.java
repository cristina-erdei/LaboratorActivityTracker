package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.DTO.StudentDTO;
import com.example.assignment_2.bussiness.model.base.Student;
import com.example.assignment_2.bussiness.model.create.StudentCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();

    Student findById(Long id);

    Student findByAuthenticationToken(String token);

    Student findByEmail(String email);

    //return register token
    String create(StudentCreateModel createModel);

    Student update(Long id, StudentCreateModel newValue);

    boolean updateAuthenticationToken(Long id, String token);

    boolean updatePassword(Long id, String password);

    boolean updateRegistered(Long id, boolean registered);

    Student deleteById(Long id);


}
