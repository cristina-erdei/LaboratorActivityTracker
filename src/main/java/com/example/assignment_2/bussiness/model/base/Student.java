package com.example.assignment_2.bussiness.model.base;

import javax.persistence.Entity;

public class Student extends User {
    private boolean registered;
    private String fullName;
    private String groupID;
    private String hobby;

    public Student() {
    }

    public Student(String email, String password, boolean registered, String fullName, String groupID, String hobby) {
        super(email, password);
        this.registered = registered;
        this.fullName = fullName;
        this.groupID = groupID;
        this.hobby = hobby;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
