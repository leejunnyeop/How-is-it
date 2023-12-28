package com.example.howIsIt.dto.response;

import com.example.howIsIt.domain.base.CustomUser;
import lombok.Data;

@Data
public class UserInfo {

    private String uid;
    private String email;
    private String nickname;

    public UserInfo(CustomUser customUser) {
        this.uid = customUser.getUsername();
        this.email = customUser.getEmail();
        this.nickname = customUser.getNickname();
    }
}
