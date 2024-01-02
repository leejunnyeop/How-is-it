package com.example.howIsIt.mentos.service;

import com.example.howIsIt.mentos.domain.dto.MentorDto;
import com.example.howIsIt.mentos.domain.dto.MentorUpdateDto;
import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import org.springframework.stereotype.Component;



public interface MentorService {




    // 만들기
    MentorDto createMentorProfile(MentorDto mentorDto);

    // 조회하기
    MentorDto infoMentorProfile(Long id);

    //업데이트 하기
    MentorUpdateDto updateMentorProfile(Long id, MentorUpdateDto mentorUpdateDto);

    void deleteMentorProfile(Long id);



}
