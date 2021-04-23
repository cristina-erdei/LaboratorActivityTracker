package com.example.assignment_2.bussiness.service.interfaces;

import com.example.assignment_2.bussiness.model.login.LoginRequestModel;
import com.example.assignment_2.bussiness.model.login.RegisterRequestModel;
import org.springframework.stereotype.Service;


@Service
public interface AuthenticationService {
    String login(LoginRequestModel loginRequestModel);
    boolean register(RegisterRequestModel registerRequestModel);
    boolean logout(String token);

}
