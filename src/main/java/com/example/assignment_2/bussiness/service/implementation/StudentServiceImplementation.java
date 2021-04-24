package com.example.assignment_2.bussiness.service.implementation;

import com.example.assignment_2.bussiness.model.base.Student;
import com.example.assignment_2.bussiness.model.create.StudentCreateModel;
import com.example.assignment_2.bussiness.service.interfaces.StudentService;
import com.example.assignment_2.data.model.StudentDB;
import com.example.assignment_2.data.repository.StudentRepository;
import com.example.assignment_2.helper.AppConstants;
import com.example.assignment_2.helper.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementation implements StudentService {


    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        List<StudentDB> students = studentRepository.findAll();
        return students.stream().map(Student::new).collect(Collectors.toList());
    }

    @Override
    public Student findById(Long id) {
        Optional<StudentDB> student = studentRepository.findById(id);
        return student.map(Student::new).orElse(null);
    }

    @Override
    public Student findByAuthenticationToken(String token) {
        StudentDB found = studentRepository.findByAuthenticationToken(token);
        if (found == null) {
            return null;
        }

        return new Student(found);
    }

    @Override
    public Student findByEmail(String email) {
        StudentDB found = studentRepository.findByEmail(email);
        if (found == null) {
            return null;
        }

        return new Student(found);
    }

    @Override
    public String create(StudentCreateModel createModel) {
        String registrationToken = TokenGenerator.generateNewToken(AppConstants.registerTokenLength);
        StudentDB student = new StudentDB(createModel.getEmail(), null, false, createModel.getFullName(), createModel.getGroupID(), createModel.getHobby(), registrationToken);
        studentRepository.save(student);
        return registrationToken;
    }

    @Override
    public Student update(Long id, StudentCreateModel newValue) {
        Optional<StudentDB> student = studentRepository.findById(id);

        if(student.isEmpty()){
            return null;
        }

        StudentDB found = student.get();

        if(newValue.getEmail() != null){
            found.setEmail(newValue.getEmail());
        }

        if(newValue.getPassword() != null){
            Base64.Encoder encoder = Base64.getEncoder();
            String encodedPassword = encoder.encodeToString(newValue.getPassword().getBytes(StandardCharsets.UTF_8));
            found.setPassword(encodedPassword);
        }

        if(newValue.getFullName() != null){
            found.setFullName(newValue.getFullName());
        }

        if(newValue.getGroupID() != null){
            found.setGroupID(newValue.getGroupID());
        }

        if(newValue.getHobby() != null){
            found.setHobby(newValue.getHobby());
        }

        StudentDB updated = studentRepository.save(found);

        return new Student(updated);
    }

    @Override
    public boolean updateAuthenticationToken(Long id, String token) {
        Optional<StudentDB> student = studentRepository.findById(id);

        if(student.isEmpty()){
            return false;
        }

        StudentDB found = student.get();
        found.setAuthenticationToken(token);

        studentRepository.save(found);

        return true;
    }

    @Override
    public boolean updatePassword(Long id, String password) {
        Optional<StudentDB> student = studentRepository.findById(id);

        if(student.isEmpty()){
            return false;
        }

        Base64.Encoder encoder = Base64.getEncoder();
        String encodedPassword = encoder.encodeToString(password.getBytes(StandardCharsets.UTF_8));

        StudentDB found = student.get();
        found.setPassword(encodedPassword);


        studentRepository.save(found);

        return true;
    }

    @Override
    public boolean updateRegistered(Long id, boolean registered) {
        Optional<StudentDB> student = studentRepository.findById(id);

        if(student.isEmpty()){
            return false;
        }

        StudentDB found = student.get();
        found.setRegistered(registered);

        studentRepository.save(found);

        return true;
    }

    @Override
    public Student deleteById(Long id) {
        Optional<StudentDB> student = studentRepository.findById(id);

        if(student.isEmpty()){
            return null;
        }

        StudentDB found = student.get();

        studentRepository.deleteById(id);

        return new Student(found);
    }
}
