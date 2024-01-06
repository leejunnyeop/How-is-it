package com.example.howIsIt.service;

import com.example.howIsIt.dto.MentorDto;
import com.example.howIsIt.dto.MentorUpdateDto;


public interface MentorService {




    // 만들기
    MentorDto createMentorProfile(MentorDto mentorDto);

    // 조회하기
    MentorDto infoMentorProfile(Long id);

    //업데이트 하기
    MentorUpdateDto updateMentorProfile(Long id, MentorUpdateDto mentorUpdateDto);

    void deleteMentorProfile(Long id);



}
