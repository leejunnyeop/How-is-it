package com.example.howIsIt.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="content", nullable = false)
    private String content;
    @Column(name="create_date")
    private Date createDate;
    @Column(name="update_date")
    private Date updateDate;
    @Column(name="status")
    private int status;
}
