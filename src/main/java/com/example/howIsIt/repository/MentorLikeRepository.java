package com.example.howIsIt.repository;

import com.example.howIsIt.domain.MentorLikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorLikeRepository extends JpaRepository<MentorLikes, Long> {


    Optional<MentorLikes> findByMentorProfileId_IdAndMemberId_Id(Long mentorProfileId, Long memberId);

    long countByMentorProfileId_Id(Long mentorId);

}
