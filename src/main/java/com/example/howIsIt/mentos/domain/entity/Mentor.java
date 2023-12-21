package com.example.howIsIt.mentos.domain.entity;

import com.example.howIsIt.base.BaseTimeEntity;
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
public class Mentor extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;

    private String content;

    @OneToMany(mappedBy = "mentor")
    private List<MentorBoard> mentorBoard;


}
