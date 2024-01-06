package com.example.howIsIt.repository;

import com.example.howIsIt.domain.MentorProfile;
import org.springframework.data.jpa.repository.JpaRepository;




public interface MentorRepository extends JpaRepository<MentorProfile, Long> {


}
