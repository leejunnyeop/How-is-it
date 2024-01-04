package com.example.howIsIt.mentos.service;

import com.example.howIsIt.base.utility.EntityFinder;
import com.example.howIsIt.domain.Member;
import com.example.howIsIt.mentos.domain.dto.MentorLikeDto;
import com.example.howIsIt.mentos.domain.entity.MentorLikes;
import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import com.example.howIsIt.mentos.repository.MentorLikeRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class MentorLikeServiceImpl implements MentorLikeService {

    private final MentorLikeRepository mentorLikeRepository;
    private final EntityFinder entityFinder;



    @Override
    public void toggleLikes(MentorLikeDto mentorLikeDto) {

        // 조회하기
        Member memberId = entityFinder.existingMemberId(mentorLikeDto.getMemberId());
        MentorProfile profileId = entityFinder.existingProfileId(mentorLikeDto.getMentorProfileId());


        // 중복확인

        Optional<MentorLikes> existingMentorLikes  = mentorLikeRepository.findByMentorProfileId_IdAndMemberId_Id(profileId.getId(), memberId.getId());

        if (existingMentorLikes.isPresent()){
            // 이미 좋아요를 눌렀으면 취소
            mentorLikeRepository.delete(existingMentorLikes.get());
        }else {
            // 안 눌렀으면 추가
            MentorLikes saveEntityLikes = MentorLikes.builder()
                    .memberId(memberId)
                    .mentorProfileId(profileId)
                    .build();

            // db 저장
            mentorLikeRepository.save(saveEntityLikes);

        }
    }

    public long countLikes(Long mentorId){
        MentorProfile profileId = entityFinder.existingProfileId(mentorId);
        return mentorLikeRepository.countByMentorProfileId_Id(profileId.getId());
    }


}
