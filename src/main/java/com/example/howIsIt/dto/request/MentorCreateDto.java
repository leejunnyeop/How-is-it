package com.example.howIsIt.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MentorCreateDto {

    private int emailCheck;
    private int cardCheck;
    private String uid;
    private String interest;
    private String business1;
    private String business2;
    private String business3;


}
