package com.example.howIsIt.mentos.service;

import com.example.howIsIt.domain.Member;
import com.example.howIsIt.domain.MemberRepository;
import com.example.howIsIt.mentos.domain.dto.ReviewDto;
import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import com.example.howIsIt.mentos.domain.entity.MentorProfileReview;
import com.example.howIsIt.mentos.repository.MentorRepository;
import com.example.howIsIt.mentos.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

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



    @Override
    public void createReview(ReviewDto reviewDto) {

        // 회원 및 프로필 존재 여부 확인
        log.info("리뷰 메소드 실행 합니다");
        Member existingMember = existingMemberId(reviewDto.getMemberId());
        log.info("memberID " + existingMember);
        MentorProfile existingProfile = existingProfileId(reviewDto.getMentorProfileId());
        log.info("profileId " + existingProfile);

        // 중복 방지
        if(reviewRepository.findByMentorProfileAndMemberId(existingProfile.getId(),existingMember.getId()).isPresent()){
            throw new IllegalArgumentException("해당 프로필 게시판에 한개에 댓글만 달 수 있습니다");
        }


        // 저장 코드
        MentorProfileReview mentorProfileReviewEntity = MentorProfileReview.builder()
                .mentorProfileId(existingProfile)
                .memberId(existingMember)
                .review(reviewDto.getReview())
                .build();

        log.info("내가 봣을땐 이거야 " + mentorProfileReviewEntity.getMemberId());
        reviewRepository.save(mentorProfileReviewEntity);
    }








}
