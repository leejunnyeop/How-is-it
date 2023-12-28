package com.example.howIsIt.controller;

import com.example.howIsIt.domain.base.CustomUser;
import com.example.howIsIt.dto.response.UserInfo;
import com.example.howIsIt.service.CustomUserService;
import com.example.howIsIt.util.RequestUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    FirebaseAuth firebaseAuth;
    @Autowired
    private CustomUserService customUserDetailsService;

    @PostMapping("")
    public UserInfo register(@RequestHeader("Authorization") String authorization,
                             @RequestBody UserInfo registerInfo) {
        // TOKEN을 가져온다.
        FirebaseToken decodedToken;
        try {
            String token = RequestUtil.getAuthorizationToken(authorization);
            decodedToken = firebaseAuth.verifyIdToken(token);
        } catch (IllegalArgumentException | FirebaseAuthException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "{\"code\":\"INVALID_TOKEN\", \"message\":\"" + e.getMessage() + "\"}");
        }
        // 사용자를 등록한다.
        CustomUser registeredUser = customUserDetailsService.register(
                decodedToken.getUid(), decodedToken.getEmail(), registerInfo.getNickname());
        return new UserInfo(registeredUser);
    }

//    @GetMapping("/me")
//    public UserInfo  getUserMe(Authentication authentication) {
//        CustomUser customUser = ((CustomUser) authentication.getPrincipal());
//        return new UserInfo(customUser);
//    }
}
