package com.example.howIsIt.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "USERS")
@Data
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String uid;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfileBoardReview> ProfileBoardReviews;

    @OneToMany(mappedBy = "usersId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MentorLikes> mentorLikes;

    public CustomUser() {
        // 기본 생성자 내용 (필요에 따라)
    }


    @Builder
    public CustomUser(String uid, String email) {
        this.uid = uid;
        this.email = email;
    }

}
