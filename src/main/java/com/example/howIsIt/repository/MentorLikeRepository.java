package com.example.howIsIt.repository;

import com.example.howIsIt.domain.MentorLikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorLikeRepository extends JpaRepository<MentorLikes, Long> {


    Optional<MentorLikes> findByMentorProfileId_IdAndUsersId_Id(Long mentorProfileId, Long usersId);

    long countByMentorProfileId_Id(Long mentorId);

}
