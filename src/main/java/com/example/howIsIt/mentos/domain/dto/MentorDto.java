package com.example.howIsIt.mentos.domain.dto;

import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import lombok.Getter;

@Getter
public class MentorDto {

    private String title;

    private String content;

    private String thumbnail;

    private String expertise;

    private String price;



    public MentorProfile mentorEntity(MentorDto mentorDto){
        return MentorProfile.builder()
                .title(mentorDto.title)
                .content(mentorDto.content)
                .thumbnail(mentorDto.thumbnail)
                .expertise(mentorDto.expertise)
                .price(mentorDto.price)
                .build();
    }


}
