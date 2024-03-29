package com.example.howIsIt.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public String sendSimpleMessage(String to) {

        int num = randomNum();
        String code = String.valueOf(num).toString();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("itimeback@gmail.com");
        message.setTo(to);
        message.setSubject(code);
        message.setText("인증코드입니다");
        emailSender.send(message);

        return code;
    }

    public int randomNum() {
        Random rand = new Random();
        return 1000 + rand.nextInt(9000);
    }
}

