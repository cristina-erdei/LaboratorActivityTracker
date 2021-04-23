package com.example.assignment_2.bussiness.service.implementation;

import com.example.assignment_2.bussiness.model.DTO.StudentDTO;
import com.example.assignment_2.bussiness.model.create.StudentCreateModel;
import com.example.assignment_2.bussiness.service.interfaces.StudentService;
import com.example.assignment_2.data.model.StudentDB;
import com.example.assignment_2.data.repository.StudentRepository;
import com.example.assignment_2.helper.AppConstants;
import com.example.assignment_2.helper.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementation implements StudentService {


    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDB> students = studentRepository.findAll();
        return students.stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(Long id) {
        Optional<StudentDB> student = studentRepository.findById(id);
        return student.map(StudentDTO::new).orElse(null);
    }

    @Override
    public StudentDTO findByAuthenticationToken(String token) {
        StudentDB found = studentRepository.findByAuthenticationToken(token);
        if (found == null) {
            return null;
        }

        return new StudentDTO(found);
    }

    @Override
    public StudentDTO findByEmail(String email) {
        StudentDB found = studentRepository.findByEmail(email);
        if (found == null) {
            return null;
        }

        return new StudentDTO(found);
    }

    @Override
    public String create(StudentCreateModel createModel) {
        String registrationToken = TokenGenerator.generateNewToken(AppConstants.registerTokenLength);
        StudentDB student = new StudentDB(createModel.getEmail(), null, false, createModel.getFullName(), createModel.getGroupID(), createModel.getHobby(), registrationToken);
        studentRepository.save(student);
        return registrationToken;
    }

    @Override
    public StudentDTO update(Long id, StudentCreateModel newValue) {
        Optional<StudentDB> student = studentRepository.findById(id);

        if(student.isEmpty()){
            return null;
        }

        StudentDB found = student.get();

        if(newValue.getEmail() != null){
            found.setEmail(newValue.getEmail());
        }

        if(newValue.getPassword() != null){
            found.setPassword(newValue.getPassword());
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

        return new StudentDTO(updated);
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

        StudentDB found = student.get();
        found.setPassword(password);

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
    public StudentDTO deleteById(Long id) {
        Optional<StudentDB> student = studentRepository.findById(id);

        if(student.isEmpty()){
            return null;
        }

        StudentDB found = student.get();

        studentRepository.deleteById(id);

        return new StudentDTO(found);
    }
}
