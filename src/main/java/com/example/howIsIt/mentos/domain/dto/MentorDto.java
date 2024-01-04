package com.example.howIsIt.mentos.domain.dto;

import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MentorDto {


    @NotNull(message = "제목은 필수 입니다.")
    @Size(min= 1, max = 30, message = "최소 1자 이상 30자 이하 입니다.")
    private String title;

    @NotNull(message = "내용을 입력 해주세요.")
    @Size(min = 10, max = 200, message = "최소 10자 이상 200자 이하 입니다. ")
    private String content;

    @NotBlank
    @Size(min = 1, max = 100, message = "최소 1자이상 100자 이하 입니다.")
    private String thumbnail;

    @NotNull(message = "직업을 선택 해주세요. ")
    private String expertise;

    @NotNull(message = "가격을 적어주세요. ")
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


    public MentorDto(String title, String content, String thumbnail, String expertise, String price){
        this.title = title;
        this.content = content;
        this.thumbnail = thumbnail;
        this.expertise =expertise;
        this.price = price;
    }

}
