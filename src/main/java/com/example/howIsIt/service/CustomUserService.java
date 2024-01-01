package com.example.howIsIt.service;

import com.example.howIsIt.domain.CustomUser;
import com.example.howIsIt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public CustomUser register(String uid, String email) {
        CustomUser user = new CustomUser();
        user.setId(uid);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }
}