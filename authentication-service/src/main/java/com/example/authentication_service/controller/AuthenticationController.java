package com.example.authentication_service.controller;

import com.example.authentication_service.model.LoginRequest;
import com.example.authentication_service.model.RegistrationRequest;
import com.example.authentication_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final RestTemplate restTemplate;
    private final JwtUtil jwtUtil;
    private final String JWT_AUTHORIZATION_HEADER = "Bearer ";

    @Autowired
    public AuthenticationController(RestTemplate restTemplate, JwtUtil jwtUtil) {
        this.restTemplate = restTemplate;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        try {
            String url = "http://USER-SERVICE/login";
            String username = restTemplate.postForObject(url, loginRequest, String.class);
            String jwt = jwtUtil.generateToken(username);
            Map<String, String> response = new HashMap();
            response.put("username", username);
            response.put("jwt", jwt);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set(JWT_AUTHORIZATION_HEADER, jwt);

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(response);
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
