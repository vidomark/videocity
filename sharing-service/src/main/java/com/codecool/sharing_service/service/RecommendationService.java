package com.codecool.sharing_service.service;

import com.codecool.sharing_service.exception.RecommendationNotFoundException;
import com.codecool.sharing_service.exception.VideoNotFoundException;
import com.codecool.sharing_service.model.Recommendation;
import com.codecool.sharing_service.repository.RecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public Set<Recommendation> getRecommendationsByVideoId(String videoId) {
        if (videoId == null || videoId.length() == 0) { // Invalid request
            log.warn("Video ID is null!");
            throw new VideoNotFoundException("Video id is null!");
        }

        Set<Recommendation> recommendations = recommendationRepository.getRecommendationByVideoId(videoId);
        if (recommendations.size() == 0) {
            throw new VideoNotFoundException(String.format("Video not found with id %s", videoId));
        }

        log.info(String.format("Recommendations found for video ID %s", videoId));
        return recommendations;
    }

    @Transactional
    public Recommendation saveRecommendationForVideo(String videoId, Recommendation recommendation) {
        if (recommendation == null || recommendation.getMessage() == null || recommendation.getVideoId() == null
                || recommendation.getMessage().length() == 0 || recommendation.getVideoId().length() == 0) {
            log.error("Invalid recommendation!");
            throw new RecommendationNotFoundException("Invalid recommendation!");
        }

        recommendation.setPostedAt(String.valueOf(LocalDateTime.now()));
        recommendation.setVideoId(videoId);
        log.info(String.format("Recommendation saved for video %s", videoId));
        return recommendationRepository.save(recommendation);
    }

    @Transactional
    public void deleteRecommendation(String id) {
        recommendationRepository.deleteById(Integer.valueOf(id));
    }

    public Recommendation editRecommendation(String id, String message) {
         Optional<Recommendation> optionalRecommendation = recommendationRepository.findById(Integer.valueOf(id));
        if (optionalRecommendation.isEmpty()) {
            log.error(String.format("Recommendation not found with id %s!", id));
            throw new RecommendationNotFoundException(String.format("Recommendation not found with id %s!", id));
        }

        Recommendation recommendation = optionalRecommendation.get();
        recommendation.setMessage(message);

        return recommendation;
    }
}
