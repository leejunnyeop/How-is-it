package com.example.howIsIt.mentos.repository;

import com.example.howIsIt.mentos.domain.entity.MentorProfileReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<MentorProfileReview, Long> {

    Optional<MentorProfileReview> findByMentorProfileAndMemberId(Long mentorId, Long memberId);
}
