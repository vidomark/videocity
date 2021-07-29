package com.codecool.video_service.service;

import com.codecool.video_service.exception.RecommendationNotFoundException;
import com.codecool.video_service.exception.VideoNotFoundException;
import com.codecool.video_service.model.Recommendation;
import com.codecool.video_service.model.Response;
import com.codecool.video_service.model.Video;
import com.codecool.video_service.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class VideoService {

    private final VideoRepository videoRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public VideoService(VideoRepository videoRepository, RestTemplate restTemplate) {
        this.videoRepository = videoRepository;
        this.restTemplate = restTemplate;
    }

    public Set<Video> getVideos() {
        log.info("Fetching every video without its recommendation(s)");
        return new HashSet<>(videoRepository.findAll());
    }

    public Response getVideoById(String id) { // With recommendations
        Optional<Video> video = videoRepository.findById(id);
        if (video.isEmpty()) {
            throw new VideoNotFoundException(String.format("Video is not found with ID %s", id));
        }

        String recommendationUrl = "http://RECOMMENDATION-SERVICE/recommendation?videoId=" + id;
        try {
            Recommendation[] recommendation = restTemplate.getForObject(recommendationUrl, Recommendation[].class);
        } catch (Exception ignored) {
            return new Response(video.get(), null);
        }
        return null;
    }
}
