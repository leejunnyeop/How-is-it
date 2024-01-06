package com.example.howIsIt.repository;

import com.example.howIsIt.domain.MentorProfileReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<MentorProfileReview, Long> {

    Optional<MentorProfileReview> findReviewByMentorProfile_IdAndMember_Id(Long mentorId, Long memberId);


}
