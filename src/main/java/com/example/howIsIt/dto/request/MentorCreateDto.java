package com.example.howIsIt.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Getter
@NoArgsConstructor
public class MentorCreateDto {

    private int emailCheck;
    private int cardCheck;
    private long usersId;
    private Date createDate;

}
