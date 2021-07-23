package com.codecool.sharing_service.controller;

import com.codecool.sharing_service.model.Recommendation;
import com.codecool.sharing_service.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> getRecommendationByVideoId(@RequestParam("videoId") String videoId) {
        Set<Recommendation> recommendations = recommendationService.getRecommendationByVideoId(videoId);
        if (recommendations == null || recommendations.size() == 0) {
            return new ResponseEntity<>(String.format("There are no recommendations with video id %s!", videoId), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }

    @PostMapping(params = "videoId")
    public ResponseEntity<Object> saveRecommendationForVideo(@RequestParam("videoId") String videoId, @RequestBody Recommendation recommendation) {
        Recommendation savedRecommendation = recommendationService.saveRecommendationForVideo(videoId, recommendation);
        if (savedRecommendation == null) {
            return new ResponseEntity<>("Invalid request, please check your recommendation!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedRecommendation, HttpStatus.OK);
    }
}
