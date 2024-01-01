package com.example.howIsIt.dto.response;

import com.example.howIsIt.domain.base.CustomUser;
import lombok.Builder;
import lombok.Data;

@Data
public class UserInfo {

    private String uid;
    private String email;

    public UserInfo(CustomUser customUser) {
        this.uid = customUser.getUsername();
        this.email = customUser.getEmail();
    }

    @Builder
    public UserInfo(String uid, String email) {
        this.uid = uid;
        this.email = email;
    }
}
