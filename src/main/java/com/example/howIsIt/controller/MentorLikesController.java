package com.example.howIsIt.controller;


import com.example.howIsIt.dto.MentorLikeDto;
import com.example.howIsIt.service.MentorLikeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
