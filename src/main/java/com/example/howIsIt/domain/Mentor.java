package com.example.howIsIt.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "mento")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email_check", nullable = false)
    private int emailCheck;

    @Column(name="card_check", nullable = false)
    private int cardCheck;

    @Column(name="users_id", nullable = false)
    private long usersId;

    @Column(name="create_date", nullable = false)
    private Date createDate;

    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="rank_count")
    private double rankCount;
    @Column(name="review_count")
    private int reviewCount;
    @Column(name="update_date")
    private Date updateDate;
    @Column(name="status")
    private int status;

}
