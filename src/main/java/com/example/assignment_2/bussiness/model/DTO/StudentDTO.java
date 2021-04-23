package com.example.assignment_2.bussiness.model.DTO;

import javax.persistence.Entity;

public class StudentDTO extends UserDTO {
    private String fullName;
    private String groupID;
    private String hobby;

    public StudentDTO() {
    }

    public StudentDTO(String email, String fullName, String groupID, String hobby) {
        super(email);
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
