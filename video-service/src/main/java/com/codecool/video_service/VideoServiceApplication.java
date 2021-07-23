package com.codecool.video_service;

import com.codecool.video_service.configuration.YoutubeApiConfiguration;
import com.codecool.video_service.model.Video;
import com.codecool.video_service.repository.VideoRepository;
import com.codecool.video_service.util.VideoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@SpringBootApplication
public class VideoServiceApplication {

    private final YoutubeApiConfiguration youtubeApiConfiguration;
    private final VideoConverter videoConverter;
    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceApplication(YoutubeApiConfiguration youtubeApiConfiguration, VideoConverter videoConverter, VideoRepository videoRepository) {
        this.youtubeApiConfiguration = youtubeApiConfiguration;
        this.videoConverter = videoConverter;
        this.videoRepository = videoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            int numberOfVideos = Math.toIntExact(videoRepository.count());
            //if (numberOfVideos < 1) { // If database is empty
            RestTemplate restTemplate = new RestTemplate();
            String youtubeApiKey = youtubeApiConfiguration.getApiKey();
            String youtubeApiChannel = String.format("https://www.googleapis.com/youtube/v3/search?key=%s&playlistId=PLxeobsc2iscCHBzruJVasVmz7z1EEk7Tf&part=snippet&type=video", youtubeApiKey);
            ResponseEntity<String> response = restTemplate.getForEntity(youtubeApiChannel, String.class);
            videoConverter.createVideos(response);

            Set<Video> videos = videoConverter.getVideos();
            videoRepository.saveAll(videos);
            //}
        };
    }


}
