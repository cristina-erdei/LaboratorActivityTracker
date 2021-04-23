package com.example.assignment_2.bussiness.service.implementation;

import com.example.assignment_2.bussiness.model.login.LoginRequestModel;
import com.example.assignment_2.bussiness.model.login.RegisterRequestModel;
import com.example.assignment_2.bussiness.service.interfaces.AuthenticationService;
import com.example.assignment_2.data.model.StudentDB;
import com.example.assignment_2.data.model.TeacherDB;
import com.example.assignment_2.data.repository.StudentRepository;
import com.example.assignment_2.data.repository.TeacherRepository;
import com.example.assignment_2.helper.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class AuthenticationServiceImplementation implements AuthenticationService {


    @Qualifier("teacherRepository")
    @Autowired
    private TeacherRepository teacherRepository;
    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherServiceImplementation teacherService;
    @Autowired
    private StudentServiceImplementation studentService;


    @Override
    public String login(LoginRequestModel loginRequestModel) {
        String authenticationToken = TokenGenerator.generateNewToken(64);
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedPassword = encoder.encodeToString(loginRequestModel.getPassword().getBytes(StandardCharsets.UTF_8));
        TeacherDB teacher = teacherRepository.findByEmail(loginRequestModel.getEmail());

        if(teacher != null){

            if(!encodedPassword.equals(teacher.getPassword())){
                return null;
            }

            teacherService.updateAuthenticationToken(teacher.getId(), authenticationToken);
            return authenticationToken;
        }

        StudentDB student = studentRepository.findByEmail(loginRequestModel.getEmail());
        if(!student.isRegistered()){
            return null;
        }

        if(!encodedPassword.equals(loginRequestModel.getPassword())) {
            return null;
        }

        boolean success = studentService.updateAuthenticationToken(student.getId(), authenticationToken);

        if(!success){
            return null;
        }

        return  authenticationToken;
    }

    @Override
    public boolean register(RegisterRequestModel registerRequestModel) {
        StudentDB student = studentRepository.findByEmail(registerRequestModel.getEmail());
        if(student == null){
            return false;
        }

        if(student.isRegistered()){
            return false;
        }

        if(!student.getRegistrationToken().equals(registerRequestModel.getRegisterToken())){
            return false;
        }

        return studentService.updatePassword(student.getId(), registerRequestModel.getNewPassword());
    }

    @Override
    public boolean logout(String token) {
        StudentDB studentDB = studentRepository.findByAuthenticationToken(token);
        if(studentDB == null){
            return false;
        }
        return studentService.updateAuthenticationToken(studentDB.getId(), null);
    }
}
