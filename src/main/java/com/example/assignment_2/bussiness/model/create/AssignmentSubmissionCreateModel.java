package com.example.assignment_2.bussiness.model.create;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class AssignmentSubmissionCreateModel {
    private Long assignmentId;
    private Long studentId;
    private String link;
    private String comment;

    public AssignmentSubmissionCreateModel() {
    }

    public AssignmentSubmissionCreateModel(Long assignment, Long student, String link, String comment) {
        this.assignmentId = assignment;
        this.studentId = student;
        this.link = link;
        this.comment = comment;
    }


    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignment) {
        this.assignmentId = assignment;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long student) {
        this.studentId = student;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
