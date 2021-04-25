package com.example.assignment_2.bussiness.model.base;

import com.example.assignment_2.data.model.AssignmentDB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class Assignment {
    private Long id;

    private Laboratory laboratory;
    private String name;
    private LocalDateTime deadline;
    private String description;

    public Assignment() {
    }

    public Assignment(Laboratory laboratory, String name, LocalDateTime deadline, String description) {
        this.laboratory = laboratory;
        this.name = name;
        this.deadline = deadline;
        this.description = description;
    }

    public Assignment(AssignmentDB assignmentDB){
        this.id = assignmentDB.getId();
        this.laboratory = new Laboratory(assignmentDB.getLaboratory());
        this.name = assignmentDB.getName();
        this.deadline = assignmentDB.getDeadline();
        this.description = assignmentDB.getDescription();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
