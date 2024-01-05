package com.example.howIsIt.mentos.repository;

import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MentorRepository extends JpaRepository<MentorProfile, Long> {

    @Query("SELECT m FROM MentorProfile m LEFT JOIN m.mentorLikes l GROUP BY m.id ORDER BY COUNT(l) DESC")
    Page<MentorProfile> findAllSortedByMentorLikesDesc(Pageable pageable);

    @Query("SELECT m FROM MentorProfile m LEFT JOIN m.mentorProfileReview r GROUP BY m.id ORDER BY COUNT(r) DESC")
    Page<MentorProfile> findAllOrderByReviewDesc(Pageable pageable);

    Page<MentorProfile> findAllByOrderByCreateDateTimeDesc(Pageable pageable);


}
