package com.example.assignment_2.data.model;

import javax.persistence.Entity;

@Entity
public class TeacherDB extends UserDB {
    public TeacherDB() {
    }

    public TeacherDB(String email, String password) {
        super(email, password);
    }
}
