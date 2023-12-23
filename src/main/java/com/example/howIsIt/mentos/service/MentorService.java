package com.example.howIsIt.mentos.service;

import com.example.howIsIt.mentos.domain.dto.MentorDto;
import com.example.howIsIt.mentos.domain.dto.MentorUpdateDto;
import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import org.springframework.stereotype.Component;


@Component
public interface MentorService {


    MentorProfile mentorProfileId(Long id);

    // 만들기
    MentorProfile createMentorProfile(MentorDto mentorDto);

    // 조회하기
    MentorProfile infoMentorProfile(Long id);

    //업데이트 하기
    MentorProfile updateMentorProfile(Long id, MentorUpdateDto mentorUpdateDto);

    void deleteMentorProfile(Long id);



}
