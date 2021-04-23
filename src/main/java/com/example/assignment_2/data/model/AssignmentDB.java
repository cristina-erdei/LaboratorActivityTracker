package com.example.assignment_2.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class AssignmentDB {
    private Long id;

    private LaboratoryDB laboratory;
    private String name;
    private LocalDateTime deadline;
    private String description;

    public AssignmentDB() {
    }

    public AssignmentDB(LaboratoryDB laboratory, String name, LocalDateTime deadline, String description) {
        this.laboratory = laboratory;
        this.name = name;
        this.deadline = deadline;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @ManyToOne
    public LaboratoryDB getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(LaboratoryDB laboratory) {
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
