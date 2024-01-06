package com.example.howIsIt.service;

import com.example.howIsIt.dto.ProfileBoardDto;
import com.example.howIsIt.dto.MentorUpdateDto;


public interface MentorService {




    // 만들기
    ProfileBoardDto createprofileBoard(ProfileBoardDto profileBoardDto);

    // 조회하기
    ProfileBoardDto infoprofileBoard(Long id);

    //업데이트 하기
    MentorUpdateDto updateprofileBoard(Long id, MentorUpdateDto mentorUpdateDto);

    void deleteprofileBoard(Long id);



}
