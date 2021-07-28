package com.example.authentication_service.configuation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("application.jwt")
public class JwtConfiguration {

    private String secretKey;
    private String tokenPrefix;
    private Long expirationDays;

    public String getSecretKey() {
        return secretKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public long getExpirationDays() {
        return expirationDays;
    }
}
