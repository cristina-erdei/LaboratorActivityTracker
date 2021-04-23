package com.example.assignment_2.bussiness.model.DTO;

import com.example.assignment_2.data.model.TeacherDB;

import javax.persistence.Entity;

public class TeacherDTO extends UserDTO {
    public TeacherDTO() {
    }

    public TeacherDTO(String email) {
        super(email);
    }

    public TeacherDTO(TeacherDB teacherDB){
        super(teacherDB.getEmail());
    }
}
