package com.codecool.video_service.controller;

import com.codecool.video_service.model.Response;
import com.codecool.video_service.model.Video;
import com.codecool.video_service.service.VideoService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/video")
@Slf4j
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public Set<Video> getVideos() {
        return videoService.getVideos();
    }

    @GetMapping(params = "id")
    @CircuitBreaker(name = "getVideoWithRecommendation", fallbackMethod = "getVideoWithRecommendationFallback")
    public ResponseEntity<Object> getVideoWithRecommendation(@RequestParam("id") String id) { // Search for video based on ID
        Response response = videoService.getVideoById(id);
        if (response == null) {
            return new ResponseEntity<>(String.format("Video is not found with id %s!", id), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ResponseEntity<Object> getVideoWithRecommendationFallback(Throwable throwable) {
        log.error("Recommendation service is down!");
        return new ResponseEntity<>("Recommendation service is down!", HttpStatus.ACCEPTED);
    }
}
