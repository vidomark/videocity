package com.codecool.sharing_service.controller;

import com.codecool.sharing_service.model.Recommendation;
import com.codecool.sharing_service.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping(params = "videoId")
    public Set<Recommendation> getRecommendationsByVideoId(@RequestParam("videoId") String videoId) {
        return recommendationService.getRecommendationsByVideoId(videoId);
    }

    @PostMapping(params = "videoId")
    public Recommendation saveRecommendationForVideo(@RequestParam("videoId") String videoId, @RequestBody Recommendation recommendation) {
        return recommendationService.saveRecommendationForVideo(videoId, recommendation);
    }

    @DeleteMapping(params = "id")
    public void deleteRecommendation(@RequestParam("id") String id) {
        recommendationService.deleteRecommendation(id);
    }

    @PutMapping
    public Recommendation editRecommendation(@RequestParam("id") String id, @RequestParam("message") String message) {
        return recommendationService.editRecommendation(id, message);
    }
}
