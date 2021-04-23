package com.example.assignment_2.data.model;

import javax.persistence.Entity;

@Entity
public class StudentDB extends UserDB {
    private boolean registered;
    private String fullName;
    private String groupID;
    private String hobby;
    private String registrationToken;

    public StudentDB() {
    }

    public StudentDB(String email, String password, boolean registered, String fullName, String groupID, String hobby, String registrationToken) {
        super(email, password);
        this.registered = registered;
        this.fullName = fullName;
        this.groupID = groupID;
        this.hobby = hobby;
        this.registrationToken = registrationToken;
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

    public String getRegistrationToken() {
        return registrationToken;
    }

    public void setRegistrationToken(String registrationToken) {
        this.registrationToken = registrationToken;
    }
}
