package com.example.assignment_2.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AttendanceDB {
    private Long id;

    private StudentDB student;
    private LaboratoryDB laboratory;

    public void setId(Long id) {
        this.id = id;
    }

    public AttendanceDB() {
    }

    public AttendanceDB(StudentDB student, LaboratoryDB laboratory) {
        this.student = student;
        this.laboratory = laboratory;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @ManyToOne
    public StudentDB getStudent() {
        return student;
    }

    public void setStudent(StudentDB student) {
        this.student = student;
    }

    @ManyToOne
    public LaboratoryDB getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(LaboratoryDB laboratory) {
        this.laboratory = laboratory;
    }
}
