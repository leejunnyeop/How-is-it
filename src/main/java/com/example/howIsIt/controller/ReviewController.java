package com.example.howIsIt.controller;

import com.example.howIsIt.dto.ReviewDto;
import com.example.howIsIt.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/crate")
    public ResponseEntity<ReviewDto> createReview(@RequestBody @Valid ReviewDto reviewDto){
        reviewService.createReview(reviewDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
