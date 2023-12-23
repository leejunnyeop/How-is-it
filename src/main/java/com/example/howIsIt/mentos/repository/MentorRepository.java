package com.example.howIsIt.mentos.repository;

import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentorRepository extends JpaRepository<MentorProfile, Long> {

  //  Optional<MentorProfile> findById(Long id);
}
