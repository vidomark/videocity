package com.codecool.video_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

    private final Video video;
    private final Recommendation[] recommendation;
}
