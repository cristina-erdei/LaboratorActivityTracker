package com.example.assignment_2.bussiness.model.create;

public class AttendanceCreateModel {
    private Long studentId;
    private Long laboratoryId;

    public AttendanceCreateModel() {
    }

    public AttendanceCreateModel(Long student, Long laboratory) {
        this.studentId = student;
        this.laboratoryId = laboratory;
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long student) {
        this.studentId = student;
    }

    public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }
}
