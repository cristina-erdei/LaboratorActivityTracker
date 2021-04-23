package com.example.assignment_2.bussiness.service.implementation;

import com.example.assignment_2.bussiness.model.DTO.StudentDTO;
import com.example.assignment_2.bussiness.model.create.StudentCreateModel;
import com.example.assignment_2.bussiness.service.interfaces.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    @Override
    public List<StudentDTO> findAll() {
        return null;
    }

    @Override
    public StudentDTO findById(Long id) {
        return null;
    }

    @Override
    public StudentDTO findByToken(String token) {
        return null;
    }

    @Override
    public String create(StudentCreateModel createModel) {
        return null;
    }

    @Override
    public StudentDTO update(Long id, StudentCreateModel newValue) {
        return null;
    }

    @Override
    public boolean updateAuthenticationToken(Long id, String token) {
        return false;
    }

    @Override
    public boolean updatePassword(Long id, String password) {
        return false;
    }

    @Override
    public void deleteById(Long id) {

    }
}
