package com.example.howIsIt.mentos.domain.entity;

import com.example.howIsIt.base.BaseTimeEntity;
import com.example.howIsIt.mentos.domain.dto.MentorDto;
import com.example.howIsIt.mentos.domain.dto.MentorUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MentorProfile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String thumbnail;

    private String expertise;

    private String price;



//    private String imageUrl;

    public void updateProfileFrom(MentorUpdateDto mentorUpdateDto) {
        if (mentorUpdateDto.getTitle() != null) {
             this.title = mentorUpdateDto.getTitle();
        }
        if (mentorUpdateDto.getContent() != null) {
            this.content = mentorUpdateDto.getContent();
        }

        if (mentorUpdateDto.getPrice() != null) {
            this.price = mentorUpdateDto.getPrice();
        }

        if (mentorUpdateDto.getThumbnail() != null) {
            this.thumbnail = mentorUpdateDto.getThumbnail();
        }

        if (mentorUpdateDto.getExpertise() != null) {
            this.expertise = mentorUpdateDto.getExpertise();
        }

    }



}
