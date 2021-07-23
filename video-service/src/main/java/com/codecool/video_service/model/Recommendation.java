package com.codecool.video_service.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Recommendation {

    private String message;
    private String postedAt;
}
