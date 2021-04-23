package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.DTO.StudentDTO;
import com.example.assignment_2.bussiness.model.create.StudentCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDTO> findAll();

    StudentDTO findById(Long id);

    StudentDTO findByToken(String token);

    //return register token
    String create(StudentCreateModel createModel);

    StudentDTO update(Long id, StudentCreateModel newValue);

    boolean updateAuthenticationToken(Long id, String token);

    boolean updatePassword(Long id, String password);

    void deleteById(Long id);


}
