package com.example.howIsIt.controller;

import com.example.howIsIt.base.BaseResponse;
import com.example.howIsIt.domain.CustomUser;
import com.example.howIsIt.dto.request.MentorCreateDto;
import com.example.howIsIt.service.CardService;
import com.example.howIsIt.service.CustomUserService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.howIsIt.util.RequestUtil;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
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
    public BaseResponse register (@RequestHeader("Authorization") String authorization,
                                  @RequestBody CustomUser customUser) {

        // TOKEN을 가져온다.
        FirebaseToken decodedToken;

        try {
            String token = RequestUtil.getAuthorizationToken(authorization);
            decodedToken = firebaseAuth.verifyIdToken(token);

        } catch (IllegalArgumentException | FirebaseAuthException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "{\"code\":\"INVALID_TOKEN\", \"message\":\"" + e.getMessage() + "\"}");
        }

        customUserDetailsService.register(decodedToken.getUid(), customUser.getEmail());

        return new BaseResponse(true, "요청에 성공하였습니다.", 2000);
    }

    @PostMapping("/card") //명함 인증
    public String extractText(@RequestPart MultipartFile file) throws IOException {

        return cardService.detectDocumentText(file);

    }

    @PostMapping("/mentor") //멘토 로그인
    public BaseResponse registerMentor(@RequestBody MentorCreateDto mentorCreateDto) {


    }
}
