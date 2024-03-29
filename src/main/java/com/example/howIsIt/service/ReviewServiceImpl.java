package com.example.howIsIt.service;

import com.example.howIsIt.util.EntityFinder;
import com.example.howIsIt.domain.Users;

import com.example.howIsIt.dto.ReviewDto;
import com.example.howIsIt.domain.ProfileBoard;
import com.example.howIsIt.domain.ProfileBoardReview;
import com.example.howIsIt.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final EntityFinder entityFinder;


    @Override
    public void createReview(ReviewDto reviewDto) {

        // 회원 및 프로필 존재 여부 확인
        Users existingusers = entityFinder.existingusersId(reviewDto.getUsersId());
        ProfileBoard existingProfile = entityFinder.existingProfileId(reviewDto.getProfileBoardId());
        // 중복 방지
        if(reviewRepository.findReviewByprofileBoard_IdAndUsers_Id(existingProfile.getId(),existingusers.getId()).isPresent()){
            throw new IllegalArgumentException("해당 프로필 게시판에 한개에 댓글만 달 수 있습니다");
        }

        // 저장 코드
        ProfileBoardReview profileBoardReviewEntity = ProfileBoardReview.builder()
                .profileBoard(existingProfile)
                .users(existingusers)
                .review(reviewDto.getReview())
                .build();

        //db 저장
        reviewRepository.save(profileBoardReviewEntity);
    }








}
