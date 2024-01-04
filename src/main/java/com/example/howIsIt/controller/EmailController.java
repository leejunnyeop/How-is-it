package com.example.howIsIt.controller;

import com.example.howIsIt.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
@RequiredArgsConstructor
@Slf4j
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/send")
    public String sendMail(@RequestParam String to) {
        emailService.sendSimpleMessage(to);
        return "Email sent!";
    }
}

