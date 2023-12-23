package com.example.howIsIt.mentos.domain.dto;

import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import lombok.Getter;

@Getter
public class MentorUpdateDto {


    private String title;

    private String content;

    private String thumbnail;

    private String expertise;

    private String price;


}
