package com.example.howIsIt.mentos.repository;

import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import org.springframework.data.jpa.repository.JpaRepository;




public interface MentorRepository extends JpaRepository<MentorProfile, Long> {


}
