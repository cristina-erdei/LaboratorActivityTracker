package com.example.assignment_2.bussiness.model.DTO;

import com.example.assignment_2.bussiness.model.base.Student;
import com.example.assignment_2.data.model.StudentDB;

public class StudentDTO extends UserDTO {
    private String fullName;
    private String groupId;
    private String hobby;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String email, String fullName, String groupID, String hobby) {
        super(id, email);
        this.fullName = fullName;
        this.groupId = groupID;
        this.hobby = hobby;
    }

    public StudentDTO(Student student){
        super(student.getId(), student.getEmail());
        this.fullName = student.getFullName();
        this.groupId = student.getGroupID();
        this.hobby = student.getHobby();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
