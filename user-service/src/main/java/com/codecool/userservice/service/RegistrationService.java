package com.codecool.userservice.service;

import com.codecool.userservice.model.User;
import com.codecool.userservice.model.dto.RegistrationRequest;
import org.bouncycastle.openssl.PasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserService userService;

    @Autowired
    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public String register(RegistrationRequest request) throws PasswordException {
        if (!request.getConfirmPassword().equals(request.getPassword())) {
            throw new PasswordException("Password and confirm password must be identical!");
        }

        userService.registerUser(User.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(request.getPassword())
                .build());

        return "Successful registration!";
    }
}
