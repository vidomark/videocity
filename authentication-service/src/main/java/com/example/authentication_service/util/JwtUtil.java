package com.example.authentication_service.util;

import com.example.authentication_service.configuation.JwtConfiguration;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class JwtUtil {

    private final JwtConfiguration jwtConfiguration;

    @Autowired
    public JwtUtil(JwtConfiguration jwtConfiguration) {
        this.jwtConfiguration = jwtConfiguration;
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

    public String generateToken(String id) {
        Claims claims = Jwts.claims().setSubject(id);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfiguration.getExpirationDate())))
                .signWith(SignatureAlgorithm.HS256, jwtConfiguration.getSecretKey())
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
