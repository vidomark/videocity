package com.codecool.video_service.service;

import com.codecool.video_service.model.Video;
import com.codecool.video_service.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Set<Video> getVideos() {
        return (Set<Video>) videoRepository.findAll();
    }

    public Optional<Video> getVideoById(int id) {
        return videoRepository.findById(id);
    }
}
