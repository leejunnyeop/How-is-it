package com.example.howIsIt.mentos.service;

import com.example.howIsIt.domain.Member;
import com.example.howIsIt.mentos.domain.dto.MentorLikeDto;

public interface MentorLikeService {

    void toggleLikes(MentorLikeDto mentorLikeDto);

}
