package com.example.howIsIt.mentos.controller;

import com.example.howIsIt.mentos.domain.dto.MentorDto;
import com.example.howIsIt.mentos.domain.dto.MentorUpdateDto;
import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import com.example.howIsIt.mentos.service.MentorService;
import com.example.howIsIt.mentos.service.MentorServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentor")
@RequiredArgsConstructor
public class MentorProfileController {

    private final MentorServiceImpl mentorService;

    @PostMapping("/create")
    public ResponseEntity<MentorDto> createProfile(@RequestBody @Valid MentorDto mentorDto){
        MentorDto mentorProfile = mentorService.createMentorProfile(mentorDto);
        return new ResponseEntity<>(mentorProfile,HttpStatus.CREATED);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<MentorDto> InfoMentorProfile(@PathVariable Long id){
        MentorDto infoMentorProfile = mentorService.infoMentorProfile(id);
        return new ResponseEntity<>(infoMentorProfile,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MentorUpdateDto> updateProfile(@PathVariable Long id, @RequestBody MentorUpdateDto mentorUpdateDto){
        MentorUpdateDto updateMentorProfile = mentorService.updateMentorProfile(id,mentorUpdateDto);
        return new ResponseEntity<>(updateMentorProfile, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id){
        mentorService.deleteMentorProfile(id);
        return ResponseEntity.noContent().build();
    }


}