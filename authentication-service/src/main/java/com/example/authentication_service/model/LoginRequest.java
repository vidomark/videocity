package com.example.authentication_service.model;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}
