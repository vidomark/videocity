package com.example.authentication_service.security.secret_key;

import com.example.authentication_service.configuation.JwtConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Component
public class SecretKeyConfiguration {

    private final JwtConfiguration jwtConfiguration;

    public SecretKeyConfiguration(JwtConfiguration jwtConfiguration) {
        this.jwtConfiguration = jwtConfiguration;
    }

    @Bean
    public SecretKey getSecretKey() {
        return new SecretKeySpec(jwtConfiguration.getSecretKey().getBytes(), "HmacSHA256");
    }
}