package com.example.assignment_2.bussiness.model.DTO;

public class AssignmentSubmissionDTO {
    private Long id;

    private AssignmentDTO assignment;
    private StudentDTO student;
    private String link;
    private String comment;
    private int grade;


    public AssignmentSubmissionDTO() {
    }

    public AssignmentSubmissionDTO(AssignmentDTO assignment, StudentDTO student, String link, String comment, int grade) {
        this.assignment = assignment;
        this.student = student;
        this.link = link;
        this.comment = comment;
        this.grade = grade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public AssignmentDTO getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentDTO assignment) {
        this.assignment = assignment;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
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
