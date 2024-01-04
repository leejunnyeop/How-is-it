package com.example.howIsIt.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String email;
    @Column
    private String uid;

    public CustomUser() {
        // 기본 생성자 내용 (필요에 따라)
    }

    @Builder
    public CustomUser(String uid, String email) {
        this.uid = uid;
        this.email = email;
    }

}
