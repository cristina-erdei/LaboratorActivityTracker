package com.example.assignment_2.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AssignmentSubmissionDB {
    private Long id;

    private AssignmentDB assignment;
    private StudentDB student;
    private String link;
    private String comment;
    private int grade;

    public AssignmentSubmissionDB() {
    }

    public AssignmentSubmissionDB(AssignmentDB assignment, StudentDB student, String link, String comment, int grade) {
        this.assignment = assignment;
        this.student = student;
        this.link = link;
        this.comment = comment;
        this.grade = grade;
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
    public AssignmentDB getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentDB assignment) {
        this.assignment = assignment;
    }

    @ManyToOne
    public StudentDB getStudent() {
        return student;
    }

    public void setStudent(StudentDB student) {
        this.student = student;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
