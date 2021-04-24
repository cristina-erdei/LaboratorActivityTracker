package com.example.assignment_2.bussiness.model.base;

import com.example.assignment_2.data.model.TeacherDB;

import javax.persistence.Entity;

public class Teacher extends User {
    public Teacher() {
    }

    public Teacher(Long id, String email, String password) {
        super(id, email, password);
    }

    public Teacher(TeacherDB teacherDB){
        super(teacherDB.getId(), teacherDB.getEmail(), teacherDB.getPassword());
    }
}
