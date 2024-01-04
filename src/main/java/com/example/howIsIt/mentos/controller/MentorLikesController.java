package com.example.howIsIt.mentos.controller;


import com.example.howIsIt.mentos.domain.dto.MentorLikeDto;
import com.example.howIsIt.mentos.service.MentorLikeService;
import com.example.howIsIt.mentos.service.MentorLikeServiceImpl;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
@RequiredArgsConstructor
public class MentorLikesController {

    private final MentorLikeServiceImpl mentorLikeService;

    @PostMapping("/heart")
    public ResponseEntity<MentorLikeDto> createHeat(@RequestBody @Valid MentorLikeDto mentorLikeDto){
        mentorLikeService.toggleLikes(mentorLikeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}
