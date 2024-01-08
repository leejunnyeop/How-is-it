package com.example.howIsIt.controller;

import com.example.howIsIt.base.BaseResponse;
import com.example.howIsIt.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emails")
@RequiredArgsConstructor
@Slf4j
public class EmailController {

    private final EmailService emailService;
    String code = "";
    @GetMapping("/send") //인증코드보냄
    public BaseResponse sendMail(@RequestParam String to) {
        code = emailService.sendSimpleMessage(to);
        return new BaseResponse(true, "요청에 성공하였습니다.", 2000);
    }

    @GetMapping("/receive") //인증코드확인
    public BaseResponse getMail(@RequestParam String verify) {

        if(verify.equals(code)) {
            return new BaseResponse(true, "요청에 성공하였습니다.", 2000);
        }
        else
            return new BaseResponse(false, "권한이 없는 유저의 접근입니다.", 4000);
    }
}

