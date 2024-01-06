package com.example.howIsIt.repository;

import com.example.howIsIt.domain.ProfileBoard;
import org.springframework.data.jpa.repository.JpaRepository;




public interface MentorRepository extends JpaRepository<ProfileBoard, Long> {


}
