package com.example.howIsIt.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "mente")
public class Mente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="users_id", nullable = false)
    private long usersId;

    @Column(name="create_date", nullable = false)
    private Date createDate;

    @Column(name="update_date")
    private Date updateDate;

    @Column(name="status")
    private int status;
}
