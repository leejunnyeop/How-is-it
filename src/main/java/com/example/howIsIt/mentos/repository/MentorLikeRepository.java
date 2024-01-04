package com.example.howIsIt.mentos.repository;

import com.example.howIsIt.mentos.domain.entity.MentorLikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MentorLikeRepository extends JpaRepository<MentorLikes, Long> {


    Optional<MentorLikes> findByMentorProfileId_IdAndMemberId_Id(Long mentorProfileId, Long memberId);

    List<MentorLikes> findByMemberId_Id(Long memberId);

    long countByMentorProfileId_Id(Long mentorId);

}
