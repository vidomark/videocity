package com.codecool.video_service.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("application.youtube")
@Data
public class YoutubeApiConfiguration {

    private String apiKey;
}
