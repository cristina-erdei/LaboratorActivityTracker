package com.example.assignment_2.bussiness.model.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

public class UserDTO {
    private Long id;
    protected String email;


    public UserDTO() {
    }

    public UserDTO(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
