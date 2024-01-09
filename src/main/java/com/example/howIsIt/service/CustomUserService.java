package com.example.howIsIt.service;

import com.example.howIsIt.domain.Users;
import com.example.howIsIt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CustomUserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public Users register(String uid, String email) {
       Users users = new Users();
       users.setUid(uid);
       users.setEmail(email);
       userRepository.save(users);
       return users;
    }

    @Transactional(readOnly = true) // 데이터 조회만 수행하므로 readOnly 옵션을 사용합니다.
    public Users getUserByUid(String uid) {
        return userRepository.findByUid(uid)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with uid: " + uid));
    }
}