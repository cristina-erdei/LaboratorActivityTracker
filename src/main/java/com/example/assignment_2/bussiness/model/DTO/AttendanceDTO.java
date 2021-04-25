package com.example.assignment_2.bussiness.model.DTO;

import com.example.assignment_2.bussiness.model.base.Attendance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class AttendanceDTO {
    private Long id;

    private StudentDTO student;
    private LaboratoryDTO laboratory;

    public void setId(Long id) {
        this.id = id;
    }

    public AttendanceDTO() {
    }

    public AttendanceDTO(StudentDTO student, LaboratoryDTO laboratory) {
        this.student = student;
        this.laboratory = laboratory;
    }

    public AttendanceDTO(Attendance attendance){
        this.id = attendance.getId();
        this.student = new StudentDTO(attendance.getStudent());
        this.laboratory = new LaboratoryDTO(attendance.getLaboratory());
    }

    public Long getId() {
        return id;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public LaboratoryDTO getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(LaboratoryDTO laboratory) {
        this.laboratory = laboratory;
    }
}
