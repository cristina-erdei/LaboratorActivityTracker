package com.example.assignment_2.bussiness.model.base;

import javax.persistence.Entity;

public class Teacher extends User {
    public Teacher() {
    }

    public Teacher(String email, String password) {
        super(email, password);
    }
}
