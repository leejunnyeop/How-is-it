package com.example.howIsIt.mentos.controller;

import com.example.howIsIt.base.ProfileBoardNotFoundException;
import com.example.howIsIt.mentos.domain.dto.MentorDto;
import com.example.howIsIt.mentos.domain.dto.MentorUpdateDto;
import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import com.example.howIsIt.mentos.service.MentorLikeServiceImpl;
import com.example.howIsIt.mentos.service.MentorServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/mentor")
@RequiredArgsConstructor
public class MentorProfileController {

    private final MentorServiceImpl mentorService;

    private final MentorLikeServiceImpl mentorLikeServiceimpl;

    @PostMapping("/create")
    public ResponseEntity<MentorDto> createProfile(@RequestBody @Valid MentorDto mentorDto){
        MentorDto mentorProfile = mentorService.createMentorProfile(mentorDto);
        return new ResponseEntity<>(mentorProfile,HttpStatus.CREATED);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<MentorDto> InfoMentorProfile(@PathVariable Long id){
        MentorDto infoMentorProfile = mentorService.infoMentorProfile(id);
        if(infoMentorProfile == null){
            throw new ProfileBoardNotFoundException("프로필 정보를 찾지 못하여 있습니다.");
        }
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

    @GetMapping("/find/heart")
    public ResponseEntity<List<MentorDto>> findMentorProfile(@RequestParam Long memberId){
        List<MentorDto> likesList = mentorService.infoLikesList(memberId);
        return ResponseEntity.ok(likesList);
    }

    @GetMapping("/main")
    public ResponseEntity<Page<MentorProfile>> orderMentorProfile(
            @RequestParam(defaultValue = "day") String sort,
            @RequestParam(defaultValue =  "5") int page,
            @RequestParam(defaultValue = "10") int size)
    {
        Page<MentorProfile> mentorProfilePage = mentorService.getMentorProfile(sort, page, size);
        return ResponseEntity.ok(mentorProfilePage);
    }


}
