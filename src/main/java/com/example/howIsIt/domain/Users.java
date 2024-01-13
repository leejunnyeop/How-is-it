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
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String uid;

    @Column
    private int status;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfileBoardReview> ProfileBoardReviews;

    @OneToMany(mappedBy = "usersId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MentorLikes> mentorLikes;

    public Users() {
        // 기본 생성자 내용 (필요에 따라)
    }

}
