package com.example.howIsIt.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    @Size(max = 20, message = "최대 20자 까지 입니다.")
    private String review;


    private Long mentorProfileId;

    private Long memberId;





}
