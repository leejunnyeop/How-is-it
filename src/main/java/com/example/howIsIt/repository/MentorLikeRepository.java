package com.example.howIsIt.repository;

import com.example.howIsIt.domain.MentorLikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorLikeRepository extends JpaRepository<MentorLikes, Long> {


    Optional<MentorLikes> findByprofileBoardId_IdAndUsersId_Id(Long profileBoardId, Long usersId);

    long countByprofileBoardId_Id(Long mentorId);

}
