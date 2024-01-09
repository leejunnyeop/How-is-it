package com.example.howIsIt.service;

import com.example.howIsIt.util.EntityFinder;
import com.example.howIsIt.domain.Users;

import com.example.howIsIt.dto.MentorLikeDto;
import com.example.howIsIt.domain.MentorLikes;
import com.example.howIsIt.domain.ProfileBoard;
import com.example.howIsIt.repository.MentorLikeRepository;
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
        Users usersId = entityFinder.existingusersId(mentorLikeDto.getUsersId());
        ProfileBoard profileId = entityFinder.existingProfileId(mentorLikeDto.getProfileBoardId());


        // 중복확인

        Optional<MentorLikes> existingMentorLikes  = mentorLikeRepository.findByprofileBoardId_IdAndUsersId_Id(profileId.getId(), usersId.getId());

        if (existingMentorLikes.isPresent()){
            // 이미 좋아요를 눌렀으면 취소
            mentorLikeRepository.delete(existingMentorLikes.get());
        }else {
            // 안 눌렀으면 추가
            MentorLikes saveEntityLikes = MentorLikes.builder()
                    .usersId(usersId)
                    .profileBoardId(profileId)
                    .build();

            // db 저장
            mentorLikeRepository.save(saveEntityLikes);

        }
    }

    public long countLikes(Long mentorId){
        ProfileBoard profileId = entityFinder.existingProfileId(mentorId);
        return mentorLikeRepository.countByprofileBoardId_Id(profileId.getId());
    }


}
