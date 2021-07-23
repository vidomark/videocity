package com.codecool.video_service.controller;

import com.codecool.video_service.model.Video;
import com.codecool.video_service.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Video getVideoById(@RequestParam("id") int id) {
        return videoService.getVideoById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Video not found with id %s", id)));
    }
}
