package com.codecool.video_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecommendationNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecommendationNotFoundException(Exception exception) {
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("Recommendation not found!", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(VideoNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleVideoNotFoundException(Exception exception) {
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("Video not found!", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
