package com.example.howIsIt.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class CustomUser {

    @Id
    private String id;
    @Column
    private String email;

    public CustomUser() {
        // 기본 생성자 내용 (필요에 따라)
    }

    @Builder
    public CustomUser(String id, String email) {
        this.id = id;
        this.email = email;
    }

    // 기본 키에 대한 접근자와 설정자 메서드
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // email 필드에 대한 접근자와 설정자 메서드는 @Data 어노테이션에 의해 자동으로 생성됩니다.
}
