package com.example.howIsIt.base.utility;

import com.example.howIsIt.domain.Member;
import com.example.howIsIt.domain.MemberRepository;
import com.example.howIsIt.domain.MentorProfile;
import com.example.howIsIt.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntityFinder {

    private final MemberRepository memberRepository;

    private final MentorRepository mentorRepository;


    public Member existingMemberId(Long memberId){
        Member getMemberId = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("없는 회원 입니다"));
        return getMemberId;
    }

    public MentorProfile existingProfileId(Long reviewId){
        MentorProfile profileId = mentorRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("없는 프로필 입니다."));
        return profileId;
    }



}
