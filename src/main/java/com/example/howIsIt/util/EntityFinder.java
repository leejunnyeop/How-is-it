package com.example.howIsIt.util;

import com.example.howIsIt.domain.Users;
import com.example.howIsIt.domain.ProfileBoard;
import com.example.howIsIt.repository.MentorRepository;
import com.example.howIsIt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntityFinder {

    private final UserRepository usersRepository;

    private final MentorRepository mentorRepository;


    public Users existingusersId(Long usersId){
        Users getUsersId = usersRepository.findById(usersId)
                .orElseThrow(() -> new IllegalArgumentException("없는 회원 입니다"));
        return getUsersId;
    }

    public ProfileBoard existingProfileId(Long reviewId){
        ProfileBoard profileId = mentorRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("없는 프로필 입니다."));
        return profileId;
    }



}
