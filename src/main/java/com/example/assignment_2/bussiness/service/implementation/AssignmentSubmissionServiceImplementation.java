package com.example.assignment_2.bussiness.service.implementation;


import com.example.assignment_2.bussiness.model.base.AssignmentSubmission;
import com.example.assignment_2.bussiness.model.create.AssignmentSubmissionCreateModel;
import com.example.assignment_2.bussiness.model.create.Grade;
import com.example.assignment_2.bussiness.service.interfaces.AssignmentSubmissionService;
import com.example.assignment_2.data.model.AssignmentDB;
import com.example.assignment_2.data.model.AssignmentSubmissionDB;
import com.example.assignment_2.data.model.StudentDB;
import com.example.assignment_2.data.repository.AssignmentRepository;
import com.example.assignment_2.data.repository.AssignmentSubmissionRepository;
import com.example.assignment_2.data.repository.StudentRepository;
import com.example.assignment_2.helper.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignmentSubmissionServiceImplementation implements AssignmentSubmissionService {


    @Qualifier("assignmentSubmissionRepository")
    @Autowired
    private AssignmentSubmissionRepository assignmentSubmissionRepository;
    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;
    @Qualifier("assignmentRepository")
    @Autowired
    private AssignmentRepository assignmentRepository;


    @Override
    public List<AssignmentSubmission> findAll() {
        List<AssignmentSubmissionDB> submissions = assignmentSubmissionRepository.findAll();
        return submissions.stream().map(AssignmentSubmission::new).collect(Collectors.toList());
    }

    @Override
    public AssignmentSubmission findById(Long id) {
        Optional<AssignmentSubmissionDB> assignmentSubmissionDB = assignmentSubmissionRepository.findById(id);
        return assignmentSubmissionDB.map(AssignmentSubmission::new).orElse(null);
    }

    @Override
    public List<AssignmentSubmission> findAllByAssignment_Id(Long assignment_Id) {
        List<AssignmentSubmissionDB> submissionDBS = assignmentSubmissionRepository.findAllByAssignment_Id(assignment_Id);
        return submissionDBS.stream().map(AssignmentSubmission::new).collect(Collectors.toList());
    }

    @Override
    public AssignmentSubmission create(AssignmentSubmissionCreateModel createModel) {
        if (createModel == null) {
            return null;
        }

        Optional<StudentDB> studentDB = studentRepository.findById(createModel.getStudentId());
        if (studentDB.isEmpty()) {
            return null;
        }

        Optional<AssignmentDB> assignmentDB = assignmentRepository.findById(createModel.getAssignmentId());
        if (assignmentDB.isEmpty()) {
            return null;
        }

        AssignmentSubmissionDB submissionDB = new AssignmentSubmissionDB(
                assignmentDB.get(),
                studentDB.get(),
                createModel.getLink(),
                createModel.getComment(),
                AppConstants.notGradedValue
                );

        AssignmentSubmissionDB saved = assignmentSubmissionRepository.save(submissionDB);

        return new AssignmentSubmission(saved);
    }

    @Override
    public AssignmentSubmission update(Long id, AssignmentSubmissionCreateModel newValue) {
        if (newValue == null) {
            return null;
        }

        Optional<AssignmentSubmissionDB> submissionDB = assignmentSubmissionRepository.findById(id);

        if (submissionDB.isEmpty()) {
            return null;
        }

        AssignmentSubmissionDB toUpdate = submissionDB.get();

        if(newValue.getAssignmentId() != null){
            Optional<AssignmentDB> assignmentDB = assignmentRepository.findById(newValue.getAssignmentId());
            assignmentDB.ifPresent(toUpdate::setAssignment);
        }

        if(newValue.getStudentId() != null){
            Optional<StudentDB> studentDB = studentRepository.findById(newValue.getStudentId());
            studentDB.ifPresent(toUpdate::setStudent);
        }

        if(newValue.getLink() != null){
            toUpdate.setLink(newValue.getLink());
        }

        if(newValue.getComment() != null){
            toUpdate.setComment(newValue.getComment());
        }


        AssignmentSubmissionDB updated = assignmentSubmissionRepository.save(toUpdate);

        return new AssignmentSubmission(updated);
    }

    @Override
    public AssignmentSubmission deleteById(Long id) {
        Optional<AssignmentSubmissionDB> submissionDB = assignmentSubmissionRepository.findById(id);

        if (submissionDB.isEmpty()) {
            return null;
        }

        AssignmentSubmissionDB toDelete = submissionDB.get();

        assignmentSubmissionRepository.deleteById(id);

        return new AssignmentSubmission(toDelete);
    }


    @Override
    public AssignmentSubmission grade(Long id, Grade grade) {
        if(grade.getGrade() < AppConstants.minGradeValue || grade.getGrade() > AppConstants.maxGradeValue){
            return null;
        }

        Optional<AssignmentSubmissionDB> submissionDB = assignmentSubmissionRepository.findById(id);

        if (submissionDB.isEmpty()) {
            return null;
        }

        AssignmentSubmissionDB found = submissionDB.get();
        found.setGrade(grade.getGrade());

        AssignmentSubmissionDB graded = assignmentSubmissionRepository.save(found);

        return new AssignmentSubmission(graded);
    }
}
