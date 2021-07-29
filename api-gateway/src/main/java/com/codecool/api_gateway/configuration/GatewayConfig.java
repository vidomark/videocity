package com.codecool.api_gateway.configuration;

import com.codecool.api_gateway.security.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().route("AUTHENTICATION-SERVICE", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("lb://AUTHENTICATION-SERVICE"))
                .route("VIDEO-SERVICE", r -> r.path("/video/**").filters(f -> f.filter(filter)).uri("lb://VIDEO-SERVICE"))
                .route("RECOMMENDATION-SERVICE", r -> r.path("/recommendation/**").filters(f -> f.filter(filter)).uri("lb://RECOMMENDATION-SERVICE"))
                .route("USER-SERVICE", r -> r.path("/registration/**", "/login/**").filters(f -> f.filter(filter)).uri("lb://USER-SERVICE"))
                .build();
    }

}
