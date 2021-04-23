package com.example.assignment_2.bussiness.model.create;

import javax.persistence.Entity;

public class StudentCreateModel extends UserCreateModel {
    private String fullName;
    private String groupID;
    private String hobby;

    public StudentCreateModel() {
    }

    public StudentCreateModel(String email, String fullName, String groupID, String hobby) {
        super(email, null);
        this.fullName = fullName;
        this.groupID = groupID;
        this.hobby = hobby;
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
