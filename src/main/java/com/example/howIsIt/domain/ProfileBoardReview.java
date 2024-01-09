package com.example.howIsIt.domain;

import com.example.howIsIt.base.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"profileBoard_id", "users_id"})
})
public class ProfileBoardReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileBoard_id", nullable = false)
    private ProfileBoard profileBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    @Column(length = 20)
    private String review;


    public void updateReview(String review) {
        if (review != null) {
            this.review = review;
        }
    }



}
