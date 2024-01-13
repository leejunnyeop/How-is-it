package com.example.howIsIt.controller;

import com.example.howIsIt.base.BaseResponse;
import com.example.howIsIt.domain.*;
import com.example.howIsIt.dto.request.MenteCreateDto;
import com.example.howIsIt.dto.request.MentorCreateDto;
import com.example.howIsIt.dto.request.SignoutDto;
import com.example.howIsIt.service.CardService;
import com.example.howIsIt.service.CustomUserService;
import com.example.howIsIt.service.UserService;
import com.example.howIsIt.util.FirebaseUserDetails;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.howIsIt.util.RequestUtil;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    FirebaseAuth firebaseAuth;
    @Autowired
    private CustomUserService customUserDetailsService;
    @Autowired
    private UserService userService;

    @Autowired private CardService cardService;

    @PostMapping("") //구글 소셜 로그인
    public BaseResponse register (@RequestHeader("Authorization") String authorization,
                                  @RequestBody Users users) {

        // TOKEN을 가져온다.
        FirebaseToken decodedToken;

        try {
            String token = RequestUtil.getAuthorizationToken(authorization);
            decodedToken = firebaseAuth.verifyIdToken(token);

        } catch (IllegalArgumentException | FirebaseAuthException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "{\"code\":\"INVALID_TOKEN\", \"message\":\"" + e.getMessage() + "\"}");
        }

        customUserDetailsService.register(decodedToken.getUid(), users.getEmail());

        return new BaseResponse(true, "요청에 성공하였습니다.", 2000);
    }

    @PostMapping("/card") //명함 인증
    public BaseResponse extractText(@RequestPart MultipartFile file) throws Exception {

        String content = "";
        content = cardService.detectDocumentText(file);

        if (!content.isBlank()) {
            return new BaseResponse(true, "요청에 성공하였습니다.", 2000);
        }
        else
            return new BaseResponse(false, "잘못된 형식입니다.", 4001);
    }

    @PostMapping("/mentorLogin") //멘토 로그인
    public BaseResponse registerMentor(@RequestBody MentorCreateDto mentorCreateDto) {

        String uid = mentorCreateDto.getUid();
        Optional<Users> users = userService.getUser(uid);
        Date today = new Date();

        if(!users.isEmpty()) {

            Mentor mentor = new Mentor(); //멘토로그인

            mentor.setUsersId(users.get().getId());
            mentor.setCardCheck(mentorCreateDto.getCardCheck());
            mentor.setEmailCheck(mentorCreateDto.getEmailCheck());
            mentor.setCreateDate(today);

            userService.MentorRegister(mentor);

            Interest interest = new Interest(); //직업 선택

            interest.setUid(uid);
            interest.setCreateDate(today);

            if(!mentorCreateDto.getInterest().isBlank()) {
                InterestCategory interestCategory = userService.getInterestCategory(mentorCreateDto.getInterest());
                interest.setInterestCategoryId(interestCategory.getId());
            }

            userService.InterestCreate(interest);

            String business1 = mentorCreateDto.getBusiness1();
            String business2 = mentorCreateDto.getBusiness2();
            String business3 = mentorCreateDto.getBusiness3();

            if(business1 != null && !business1.isBlank()) { //비즈니스 선택 (복수 선택)
                Business business = userService.getBusiness(business1);
                MentorBusiness mentorBusiness = new MentorBusiness();
                mentorBusiness.setBusinessId(business.getId());
                mentorBusiness.setCreateDate(today);
                userService.MentorBusinessCreate(mentorBusiness);
            }

            if(business2 != null && !business2.isBlank()) { //비즈니스 선택 (복수 선택)
                Business business = userService.getBusiness(business2);
                MentorBusiness mentorBusiness = new MentorBusiness();
                mentorBusiness.setBusinessId(business.getId());
                mentorBusiness.setCreateDate(today);
                userService.MentorBusinessCreate(mentorBusiness);
            }

            if(business3 != null && !business3.isBlank()) { //비즈니스 선택 (복수 선택)
                Business business = userService.getBusiness(business3);
                MentorBusiness mentorBusiness = new MentorBusiness();
                mentorBusiness.setBusinessId(business.getId());
                mentorBusiness.setCreateDate(today);
                userService.MentorBusinessCreate(mentorBusiness);
            }

            return new BaseResponse(true, "요청에 성공하였습니다", 2000);
        }

        return new BaseResponse(false, "잘못된 형식입니다", 4001);
    }

    @PostMapping("/menteLogin")
    public BaseResponse registerMente(@RequestBody MenteCreateDto menteCreateDto) {

        String uid = menteCreateDto.getUid();
        Optional<Users> users = userService.getUser(uid);
        Date today = new Date();

        if(!users.isEmpty()) {

            Mente mente = new Mente(); //멘티로그인

            mente.setUsersId(users.get().getId());
            mente.setCreateDate(today);

            userService.MenteRegister(mente);

            Interest interest = new Interest(); //직업 선택

            interest.setUid(uid);
            interest.setCreateDate(today);

            if(!menteCreateDto.getInterest().isBlank()) {
                InterestCategory interestCategory = userService.getInterestCategory(menteCreateDto.getInterest());
                interest.setInterestCategoryId(interestCategory.getId());
            }

            userService.InterestCreate(interest);

            String business1 = menteCreateDto.getBusiness1();
            String business2 = menteCreateDto.getBusiness2();
            String business3 = menteCreateDto.getBusiness3();

            if(business1 != null && !business1.isBlank()) { //비즈니스 선택 (복수 선택)
                Business business = userService.getBusiness(business1);
                MenteBusiness menteBusiness = new MenteBusiness();
                menteBusiness.setBusinessId(business.getId());
                menteBusiness.setCreateDate(today);
                userService.MenteBusinessCreate(menteBusiness);
            }

            if(business2 != null && !business2.isBlank()) { //비즈니스 선택 (복수 선택)
                Business business = userService.getBusiness(business2);
                MenteBusiness menteBusiness = new MenteBusiness();
                menteBusiness.setBusinessId(business.getId());
                menteBusiness.setCreateDate(today);
                userService.MenteBusinessCreate(menteBusiness);
            }

            if(business3 != null && !business3.isBlank()) { //비즈니스 선택 (복수 선택)
                Business business = userService.getBusiness(business3);
                MenteBusiness menteBusiness = new MenteBusiness();
                menteBusiness.setBusinessId(business.getId());
                menteBusiness.setCreateDate(today);
                userService.MenteBusinessCreate(menteBusiness);
            }

            return new BaseResponse(true, "요청에 성공하였습니다", 2000);
        }

        return new BaseResponse(false, "잘못된 형식입니다", 4001);
    }

    @PostMapping("/signout")
    public BaseResponse UsersSignout(@RequestBody SignoutDto signoutDto) {

        String email;
        String uid;

        email = signoutDto.getEmail();
        uid = signoutDto.getUid();


    }
}
