package com.example.howIsIt.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {

    private String password;

    private String email;

    public Member memberEntity(MemberDto memberDto){
        return Member.builder()
                .email(memberDto.email)
                .password(memberDto.password)
                .build();
    }
}
