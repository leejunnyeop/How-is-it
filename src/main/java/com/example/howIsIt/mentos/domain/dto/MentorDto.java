package com.example.howIsIt.mentos.domain.dto;

import com.example.howIsIt.mentos.domain.entity.Mentor;
import lombok.Getter;

@Getter
public class MentorDto {

    private String title;

    private String content;

    private float rankCount;

    private Integer reviewCount;

    public Mentor mentorEntity(MentorDto mentorDto){
        return Mentor.builder()
                .title(mentorDto.title)
                .content(mentorDto.content)
                .rankCount(mentorDto.rankCount)
                .reviewCount(mentorDto.reviewCount)
                .build();
    }


}
