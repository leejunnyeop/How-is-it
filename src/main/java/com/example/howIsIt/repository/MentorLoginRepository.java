package com.example.howIsIt.repository;

import com.example.howIsIt.domain.Mentor;
import com.example.howIsIt.domain.ProfileBoard;
import com.example.howIsIt.dto.request.MentorCreateDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorLoginRepository extends JpaRepository<Mentor, Long> {

    void mentorRegister(MentorCreateDto mentorCreateDto);
}
