package com.example.assignment_2.bussiness.service.implementation;

import com.example.assignment_2.bussiness.model.base.Student;
import com.example.assignment_2.bussiness.model.base.Teacher;
import com.example.assignment_2.bussiness.model.login.LoginRequestModel;
import com.example.assignment_2.bussiness.model.login.RegisterRequestModel;
import com.example.assignment_2.bussiness.service.interfaces.AuthenticationService;
import com.example.assignment_2.helper.AppConstants;
import com.example.assignment_2.helper.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class AuthenticationServiceImplementation implements AuthenticationService {

    @Autowired
    private TeacherServiceImplementation teacherService;
    @Autowired
    private StudentServiceImplementation studentService;


    @Override
    public String login(LoginRequestModel loginRequestModel) {
        String authenticationToken = TokenGenerator.generateNewToken(AppConstants.authenticationTokenLength);
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedPassword = encoder.encodeToString(loginRequestModel.getPassword().getBytes(StandardCharsets.UTF_8));
        Teacher teacher = teacherService.findByEmail(loginRequestModel.getEmail());

        if(teacher != null){

            if(!encodedPassword.equals(teacher.getPassword())){
                return null;
            }

            boolean success = teacherService.updateAuthenticationToken(teacher.getId(), authenticationToken);
            if(!success){
                return null;
            }

            return authenticationToken;
        }

        Student student = studentService.findByEmail(loginRequestModel.getEmail());
        if(!student.isRegistered()){
            return null;
        }

        if(!encodedPassword.equals(student.getPassword())) {
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
        Student student = studentService.findByEmail(registerRequestModel.getEmail());
        if(student == null){
            return false;
        }

        if(student.isRegistered()){
            return false;
        }

        if(student.getRegistrationToken() == null){
            return false;
        }

        if(!student.getRegistrationToken().equals(registerRequestModel.getRegisterToken())){
            return false;
        }


        boolean success = studentService.updatePassword(student.getId(), registerRequestModel.getNewPassword());

        if(!success){
            return false;
        }

        return studentService.updateRegistered(student.getId(), true);
    }

    @Override
    public boolean logout(String token) {
        Teacher teacher = teacherService.findByAuthenticationToken(token);
        if(teacher != null){
            return teacherService.updateAuthenticationToken(teacher.getId(), null);
        }

        Student student = studentService.findByAuthenticationToken(token);
        if(student == null){
            return false;
        }
        return studentService.updateAuthenticationToken(student.getId(), null);
    }
}
