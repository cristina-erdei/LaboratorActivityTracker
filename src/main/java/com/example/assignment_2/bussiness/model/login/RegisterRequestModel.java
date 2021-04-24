package com.example.assignment_2.bussiness.model.login;

public class RegisterRequestModel {
    private String registerToken;
    private String email;
    private String newPassword;

    public RegisterRequestModel() {
    }

    public RegisterRequestModel(String registerToken, String email, String newPassword) {
        this.registerToken = registerToken;
        this.email = email;
        this.newPassword = newPassword;
    }

    public String getRegisterToken() {
        return registerToken;
    }

    public void setRegisterToken(String registerToken) {
        this.registerToken = registerToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "RegisterRequestModel{" +
                "registerToken='" + registerToken + '\'' +
                ", email='" + email + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
