package com.codecool.api_gateway.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("spring.application.jwt")
@Data
public class JwtConfiguration {

    private String secretKey;
    private String tokenPrefix;
    private Long expirationDate;
}