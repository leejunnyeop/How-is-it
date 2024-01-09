package com.example.howIsIt.service;

import com.example.howIsIt.dto.request.MentorCreateDto;
import com.example.howIsIt.repository.MentorLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    MentorLoginRepository mentorLoginRepository;

    @Transactional //멘토 로그인
    public void MentorRegister (MentorCreateDto mentorCreateDto) {
        mentorLoginRepository.mentorRegister(mentorCreateDto);
    }
}
