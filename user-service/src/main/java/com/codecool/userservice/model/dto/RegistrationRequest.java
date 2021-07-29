package com.codecool.userservice.model.dto;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String email;
    private String username;
    private String password;
    private String confirmPassword;
}