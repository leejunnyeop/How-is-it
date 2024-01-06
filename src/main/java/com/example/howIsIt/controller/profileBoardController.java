package com.example.howIsIt.controller;

import com.example.howIsIt.dto.ProfileBoardDto;
import com.example.howIsIt.dto.MentorUpdateDto;
import com.example.howIsIt.service.MentorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mentor")
@RequiredArgsConstructor
public class profileBoardController {

    private final MentorServiceImpl mentorService;

    @PostMapping("/create")
    public ResponseEntity<ProfileBoardDto> createProfile(@RequestBody @Valid ProfileBoardDto profileBoardDto){
        ProfileBoardDto profileBoard = mentorService.createprofileBoard(profileBoardDto);
        return new ResponseEntity<>(profileBoard,HttpStatus.CREATED);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<ProfileBoardDto> InfoprofileBoard(@PathVariable Long id){
        ProfileBoardDto infoprofileBoard = mentorService.infoprofileBoard(id);
        return new ResponseEntity<>(infoprofileBoard,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MentorUpdateDto> updateProfile(@PathVariable Long id, @RequestBody MentorUpdateDto mentorUpdateDto){
        MentorUpdateDto updateprofileBoard = mentorService.updateprofileBoard(id,mentorUpdateDto);
        return new ResponseEntity<>(updateprofileBoard, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id){
        mentorService.deleteprofileBoard(id);
        return ResponseEntity.noContent().build();
    }


}
