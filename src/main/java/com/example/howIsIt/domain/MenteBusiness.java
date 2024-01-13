package com.example.howIsIt.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "mente_business")
public class MenteBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="mente_id", nullable = false)
    private Long menteId;
    @Column(name="business_id", nullable = false)
    private Long businessId;
    @Column(name="create_date")
    private Date createDate;
    @Column(name="update_date")
    private Date updateDate;
    @Column(name="status")
    private int status;
}
