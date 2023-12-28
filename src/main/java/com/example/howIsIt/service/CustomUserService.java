package com.example.howIsIt.service;

import com.example.howIsIt.domain.base.CustomUser;
import com.example.howIsIt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username).get();
    }

    @Transactional
    public CustomUser register(String uid, String email, String nickname) {
        CustomUser customUser = CustomUser.builder()
                .username(uid)
                .email(email)
                .nickname(nickname)
                .build();
        userRepository.save(customUser);
        return customUser;
    }
}