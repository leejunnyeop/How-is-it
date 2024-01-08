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
       CustomUser customUser = new CustomUser();
       customUser.setUid(uid);
       customUser.setEmail(email);
       userRepository.save(customUser);
       return customUser;
    }
}