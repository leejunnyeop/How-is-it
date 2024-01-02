package com.example.howIsIt.mentos.controller;

import com.example.howIsIt.mentos.domain.dto.ReviewDto;
import com.example.howIsIt.mentos.service.ReviewService;
import com.example.howIsIt.mentos.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    @PostMapping("/crate")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto){
        reviewService.createReview(reviewDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
