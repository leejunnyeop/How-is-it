package com.example.howIsIt.mentos.controller;

import com.example.howIsIt.mentos.domain.dto.ReviewDto;
import com.example.howIsIt.mentos.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
