package com.example.assignment_2.bussiness.model.DTO;

import com.example.assignment_2.bussiness.model.base.Teacher;
import com.example.assignment_2.data.model.TeacherDB;

import javax.persistence.Entity;

public class TeacherDTO extends UserDTO {
    public TeacherDTO() {
    }

    public TeacherDTO(Long id, String email) {
        super(id, email);
    }

    public TeacherDTO(Teacher teacher){
        super(teacher.getId(), teacher.getEmail());
    }
}
