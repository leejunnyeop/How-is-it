package com.example.howIsIt.service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("itimeback@gmail.com");
        message.setTo(to);
        message.setSubject("portfolier 인증 메일");
        message.setText("이메일 인증을 위해 아래의 버튼을 눌러주세요");
        emailSender.send(message);
    }
}

