package com.example.assignment_2.bussiness.controller;

import com.example.assignment_2.bussiness.model.login.LoginRequestModel;
import com.example.assignment_2.bussiness.model.login.RegisterRequestModel;
import com.example.assignment_2.bussiness.service.implementation.AuthenticationServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationServiceImplementation authenticationService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestModel loginRequestModel) {
        String authenticationToken = authenticationService.login(loginRequestModel);

        if(authenticationToken == null){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(authenticationToken, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestModel registerRequestModel) {
        boolean success = authenticationService.register(registerRequestModel);

        if(!success){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }


        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Token") String token) {
        boolean success = authenticationService.logout(token);

        if(!success){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
