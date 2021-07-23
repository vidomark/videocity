package com.codecool.video_service.controller;

import com.codecool.video_service.model.Response;
import com.codecool.video_service.model.Video;
import com.codecool.video_service.service.VideoService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/video")
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
    public ResponseEntity<Object> getVideoById(@RequestParam("id") String id) { // With recommendations
        Response response = videoService.getVideoById(id);
        if (response == null) {
            return new ResponseEntity<>(String.format("Video is not found with id %s!", id), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
