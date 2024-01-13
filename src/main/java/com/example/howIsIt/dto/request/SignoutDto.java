package com.example.howIsIt.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignoutDto {   //회원탈퇴

    private String email;
    private String uid;
}
