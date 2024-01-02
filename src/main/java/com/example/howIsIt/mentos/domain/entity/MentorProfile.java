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

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 200)
    private String content;

    @Column(nullable = false, length = 100)
    private String thumbnail;

    @Column(nullable = false)
    private String expertise;

    @Column(nullable = false)
    private String price;

    @OneToMany(mappedBy = "mentorProfileId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MentorProfileReview> mentorProfileReview;



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
