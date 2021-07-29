package com.example.authentication_service.controller;

import com.example.authentication_service.model.LoginRequest;
import com.example.authentication_service.model.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final RestTemplate restTemplate;

    @Autowired
    public AuthenticationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String url = "http://USER-SERVICE/login";
        try {
            String response = restTemplate.postForObject(url, loginRequest, String.class);
            return response;
        } catch (Exception exception) {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @PostMapping("/registration")
    public String register(@RequestBody RegistrationRequest registrationRequest) {
        String url = "http://USER-SERVICE/registration";
        try {
            return restTemplate.postForObject(url, registrationRequest, String.class);
        } catch (Exception exception) {
            throw new RuntimeException("Invalid registration!");
        }
    }
}
