package com.codecool.sharing_service.service;

import com.codecool.sharing_service.model.Recommendation;
import com.codecool.sharing_service.repository.RecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Set;

@Service
@Slf4j
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public Set<Recommendation> getRecommendationByVideoId(String videoId) {
        if (videoId == null || videoId.length() == 0) { // Invalid request
            log.warn("Video ID is null!");
            return null;
        }

        log.info(String.format("Recommendation found for video ID %s", videoId));
        return recommendationRepository.getRecommendationByVideoId(videoId);
    }

    @Transactional
    public Recommendation saveRecommendationForVideo(String videoId, Recommendation recommendation) {
        if (recommendation == null || recommendation.getMessage() == null || recommendation.getVideoId() == null
                || recommendation.getMessage().length() == 0 || recommendation.getVideoId().length() == 0) {
            log.error("Invalid recommendation!");
            return null;
        }

        recommendation.setPostedAt(String.valueOf(LocalDateTime.now()));
        recommendation.setVideoId(videoId);
        log.info(String.format("Recommendation saved for video %s", videoId));
        return recommendationRepository.save(recommendation);
    }
}
