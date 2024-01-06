package com.example.howIsIt.repository;

import com.example.howIsIt.domain.ProfileBoardReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ProfileBoardReview, Long> {

    Optional<ProfileBoardReview> findReviewByprofileBoard_IdAndUsers_Id(Long mentorId, Long usersId);


}
