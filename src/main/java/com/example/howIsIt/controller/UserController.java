package com.example.howIsIt.controller;

import com.example.howIsIt.base.BaseResponse;
import com.example.howIsIt.domain.CustomUser;
import com.example.howIsIt.service.CardService;
import com.example.howIsIt.service.CustomUserService;
import com.google.firebase.auth.FirebaseAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    FirebaseAuth firebaseAuth;
    @Autowired
    private CustomUserService customUserDetailsService;

    @Autowired private CardService cardService;

    @PostMapping("") //구글 소셜 로그인
    public BaseResponse register (@RequestBody CustomUser customUser) {

        String email = ""; String uid = "";

        try {
            email = customUser.getEmail();
            uid = customUser.getUid();
        } catch (IllegalArgumentException e) {
            return new BaseResponse(false, "권한이 없는 유저의 접근입니다.", 4004);
        }

        customUserDetailsService.register(uid, email);

        return new BaseResponse(true, "요청에 성공하였습니다.", 2000);
    }

    @PostMapping("/card")
    public String extractText(@RequestPart MultipartFile file) throws IOException {

        return cardService.detectDocumentText(file);

    }

}
