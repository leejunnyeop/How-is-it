package com.example.howIsIt.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    private ResponseEntity<Object> createMember(@RequestBody MemberDto memberDto){
        Member createMember = memberService.createMember(memberDto);
        return new ResponseEntity<>(createMember,HttpStatus.CREATED);
    }
}
