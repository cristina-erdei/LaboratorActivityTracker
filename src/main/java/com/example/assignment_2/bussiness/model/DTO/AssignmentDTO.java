package com.example.assignment_2.bussiness.model.DTO;

import com.example.assignment_2.bussiness.model.base.Assignment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class AssignmentDTO {
    private Long id;

    private LaboratoryDTO laboratory;
    private String name;
    private LocalDateTime deadline;
    private String description;

    public AssignmentDTO() {
    }

    public AssignmentDTO(LaboratoryDTO laboratory, String name, LocalDateTime deadline, String description) {
        this.laboratory = laboratory;
        this.name = name;
        this.deadline = deadline;
        this.description = description;
    }

    public AssignmentDTO(Assignment assignment){
        this.id = assignment.getId();
        this.laboratory = new LaboratoryDTO(assignment.getLaboratory());
        this.name = assignment.getName();
        this.deadline = assignment.getDeadline();
        this.description = assignment.getDescription();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LaboratoryDTO getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(LaboratoryDTO laboratory) {
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
