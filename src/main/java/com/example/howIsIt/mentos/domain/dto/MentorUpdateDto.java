package com.example.howIsIt.mentos.domain.dto;

import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MentorUpdateDto {


    private String title;

    private String content;

    private String thumbnail;

    private String expertise;

    private String price;




}
