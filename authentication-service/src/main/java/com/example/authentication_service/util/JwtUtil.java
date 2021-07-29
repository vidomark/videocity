package com.example.authentication_service.util;

import com.example.authentication_service.configuation.JwtConfiguration;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.Date;

@Component
public class JwtUtil {

    private final JwtConfiguration jwtConfiguration;
    private final SecretKey secretKey;

    @Autowired
    public JwtUtil(JwtConfiguration jwtConfiguration, SecretKey secretKey) {
        this.jwtConfiguration = jwtConfiguration;
        this.secretKey = secretKey;
    }

    public Claims getClaims(final String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtConfiguration.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception exception) {
            throw new JwtException("Could not get claims!");
        }
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public void validateToken(final String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtConfiguration.getSecretKey())
                    .parseClaimsJws(token);
        } catch (Exception exception) {
            throw new JwtException("Could not validate token!");
        }
    }
}
