package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.DTO.AssignmentDTO;
import com.example.assignment_2.bussiness.model.DTO.AssignmentSubmissionDTO;
import com.example.assignment_2.bussiness.model.DTO.TeacherDTO;
import com.example.assignment_2.bussiness.model.base.Teacher;
import com.example.assignment_2.bussiness.model.create.AssignmentCreateModel;
import com.example.assignment_2.bussiness.model.create.AssignmentSubmissionCreateModel;
import com.example.assignment_2.bussiness.model.create.TeacherCreateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    List<Teacher> findAll();

    Teacher findByToken(String token);

    Teacher findById(Long id);

    Teacher findByEmail(String email);

    Teacher create(TeacherCreateModel createModel);

    Teacher update(Long id, TeacherCreateModel createModel);

    boolean updateAuthenticationToken(Long id, String token);

    Teacher deleteById(Long id);


}

