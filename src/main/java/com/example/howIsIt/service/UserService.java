package com.example.howIsIt.service;

import com.example.howIsIt.domain.Mentor;
import com.example.howIsIt.domain.Users;
import com.example.howIsIt.dto.request.MentorCreateDto;
import com.example.howIsIt.repository.MentorLoginRepository;
import com.example.howIsIt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    MentorLoginRepository mentorLoginRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional //멘토 로그인
    public Mentor MentorRegister (Mentor mentor) {
        return mentorLoginRepository.save(mentor);
    }

    @Transactional
    public Optional<Users> getUser(String uid) {
        return userRepository.findByUid(uid);
    }
}
