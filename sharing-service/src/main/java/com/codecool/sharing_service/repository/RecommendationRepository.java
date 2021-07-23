package com.codecool.sharing_service.repository;

import com.codecool.sharing_service.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {

    @Query("SELECT recommendation FROM Recommendation recommendation WHERE recommendation.videoId = :videoId")
    Set<Recommendation> getRecommendationByVideoId(@Param("videoId") String videoId);
}
