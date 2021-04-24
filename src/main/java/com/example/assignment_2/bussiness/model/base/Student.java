package com.example.assignment_2.bussiness.model.base;

import com.example.assignment_2.data.model.StudentDB;

public class Student extends User {
    private boolean registered;
    private String fullName;
    private String groupID;
    private String hobby;
    private String registrationToken;

    public Student() {
    }

    public Student(Long id, String email, String password, boolean registered, String fullName, String groupID, String hobby, String registrationToken) {
        super(id, email, password);
        this.registered = registered;
        this.fullName = fullName;
        this.groupID = groupID;
        this.hobby = hobby;
        this.registrationToken = registrationToken;
    }

    public Student(StudentDB studentDB){
        super(studentDB.getId(), studentDB.getEmail(), studentDB.getPassword());
        this.registered = studentDB.isRegistered();
        this.fullName = studentDB.getFullName();
        this.groupID = studentDB.getGroupID();
        this.hobby = studentDB.getHobby();
        this.registrationToken = studentDB.getRegistrationToken();
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

    @Override
    public String toString() {
        return "Student{" +
                "registered=" + registered +
                ", fullName='" + fullName + '\'' +
                ", groupID='" + groupID + '\'' +
                ", hobby='" + hobby + '\'' +
                ", registrationToken='" + registrationToken + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
