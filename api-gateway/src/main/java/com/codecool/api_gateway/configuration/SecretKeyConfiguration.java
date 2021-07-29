package com.codecool.api_gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Configuration
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
