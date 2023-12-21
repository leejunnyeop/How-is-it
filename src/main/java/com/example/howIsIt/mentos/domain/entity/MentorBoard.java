package com.example.howIsIt.mentos.domain.entity;

import com.example.howIsIt.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MentorBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentorID")
    private Mentor mentor;

    @OneToMany(mappedBy = "mentorBoard")
    private List<MentorLike> mentorLikes;


}
