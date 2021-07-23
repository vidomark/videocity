package com.codecool.sharing_service;

import com.codecool.sharing_service.model.Recommendation;
import com.codecool.sharing_service.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SharingServiceApplication {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public SharingServiceApplication(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SharingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Recommendation recommendationOne = Recommendation.builder()
                    .message("Alright you vagabonds, Netflix has a thing of cancelling shows so with that being said, all us Witcher fans need to to at least watch this twice so they can at least finish off this series.")
                    .postedAt("2021-07-14T07:35:00Z")
                    .build();

            Recommendation recommendationTwo = Recommendation.builder()
                    .message("No one seems to be talking about that choice use of Fleet Foxes in the background. That self-titled album was a masterpiece, and \"Your Protector\" is very fitting.")
                    .postedAt("2020-09-11T07:32:00Z")
                    .build();

            Recommendation recommendationThree = Recommendation.builder()
                    .message("I've always thought this was the most elegant and gentle way Arya could let Brienne know that she really didn't her protection.")
                    .postedAt("2010-05-19T07:25:00Z")
                    .build();

            Recommendation recommendationFour = Recommendation.builder()
                    .message("Anyone else think this scene is meant to mirror the first time she trained with Syrio? Back then Ned walked in and looked worried because he knew Arya was set on the path of a warrior.")
                    .postedAt("2014-12-19T01:43:00Z")
                    .build();

            Recommendation recommendationFive = Recommendation.builder()
                    .message("Can we all take a moment to appreciate how incredible Peter Dinklage's acting was throughout all 8 seasons? Some of the finest acting I've ever seen.")
                    .postedAt("2020-10-11T01:43:00Z")
                    .build();

            Recommendation recommendationSix = Recommendation.builder()
                    .message("By the old and the new gods, Bran felt like a villain in the end. One might think that he used his Greenseer powers to read the future and manipulate it in ways so that he ends up being King.")
                    .postedAt("2019-8-20T01:43:00Z")
                    .build();

            recommendationRepository.saveAll(Arrays.asList(
                    recommendationOne,
                    recommendationTwo,
                    recommendationThree,
                    recommendationFour,
                    recommendationFive,
                    recommendationSix
            ));
        };
    }
}
