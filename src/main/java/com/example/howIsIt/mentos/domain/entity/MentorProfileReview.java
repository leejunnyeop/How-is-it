package com.example.howIsIt.mentos.domain.entity;

import com.example.howIsIt.base.BaseTimeEntity;
import com.example.howIsIt.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"mentorProfile_id", "user_id"})
})
public class MentorProfileReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentorProfile_id", nullable = false)
    private MentorProfile mentorProfileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Member memberId;

    @Column(length = 20)
    private String review;


    public void updateReview(String review) {
        if (review != null) {
            this.review = review;
        }
    }



}
