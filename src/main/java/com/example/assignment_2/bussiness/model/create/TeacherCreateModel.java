package com.example.assignment_2.bussiness.model.create;

import javax.persistence.Entity;

public class TeacherCreateModel extends UserCreateModel {
    public TeacherCreateModel() {
    }

    public TeacherCreateModel(String email, String password) {
        super(email, password);
    }
}
