package com.example.assignment_2.bussiness.model.base;

import com.example.assignment_2.data.model.AssignmentSubmissionDB;

public class AssignmentSubmission {
    private Long id;

    private Assignment assignment;
    private Student student;
    private String link;
    private String comment;
    private int grade;


    public AssignmentSubmission() {
    }

    public AssignmentSubmission(Assignment assignment, Student student, String link, String comment, int grade) {
        this.assignment = assignment;
        this.student = student;
        this.link = link;
        this.comment = comment;
        this.grade = grade;
    }

    public AssignmentSubmission(AssignmentSubmissionDB assignmentSubmissionDB){
        this.id = assignmentSubmissionDB.getId();
        this.assignment = new Assignment(assignmentSubmissionDB.getAssignment());
        this.student = new Student(assignmentSubmissionDB.getStudent());
        this.link = assignmentSubmissionDB.getLink();
        this.comment = assignmentSubmissionDB.getComment();
        this.grade = assignmentSubmissionDB.getGrade();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
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
