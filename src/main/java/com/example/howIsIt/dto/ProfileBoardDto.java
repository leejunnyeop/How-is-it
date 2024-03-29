package com.example.howIsIt.dto;

import com.example.howIsIt.domain.ProfileBoard;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class ProfileBoardDto {


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



    public ProfileBoard mentorEntity(ProfileBoardDto profileBoardDto){
        return ProfileBoard.builder()
                .title(profileBoardDto.title)
                .content(profileBoardDto.content)
                .thumbnail(profileBoardDto.thumbnail)
                .expertise(profileBoardDto.expertise)
                .price(profileBoardDto.price)
                .build();
    }


    public ProfileBoardDto(String title, String content, String thumbnail, String expertise, String price){
        this.title = title;
        this.content = content;
        this.thumbnail = thumbnail;
        this.expertise =expertise;
        this.price = price;
    }

}
