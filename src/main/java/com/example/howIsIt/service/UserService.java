package com.example.howIsIt.service;

import com.example.howIsIt.domain.*;
import com.example.howIsIt.dto.request.MentorCreateDto;
import com.example.howIsIt.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    MentorLoginRepository mentorLoginRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    InterestRepository interestRepository;
    @Autowired
    InterestCategoryRepository interestCategoryRepository;
    @Autowired
    BusinessRepository businessRepository;
    @Autowired
    MentorBusinessRepository mentorBusinessRepository;
    @Autowired
    MenteLoginRepository menteLoginRepository;
    @Autowired
    MenteBusinessRepository menteBusinessRepository;

    @Transactional
    public Mente MenteRegister (Mente mente) {return menteLoginRepository.save(mente);}
    @Transactional //멘토 로그인
    public Mentor MentorRegister (Mentor mentor) {
        return mentorLoginRepository.save(mentor);
    }

    @Transactional
    public InterestCategory getInterestCategory(String content) {
        return interestCategoryRepository.getInterestCategoryByContent(content);
    }
    @Transactional //직업테이블추가
    public Interest InterestCreate (Interest interest) {
        return interestRepository.save(interest);
    }

    @Transactional
    public Optional<Users> getUser(String uid) {
        return userRepository.findByUid(uid);
    }

    @Transactional
    public Business getBusiness(String content) {return businessRepository.getBusinessByContent(content);}

    @Transactional
    public MenteBusiness MenteBusinessCreate(MenteBusiness menteBusiness) { return menteBusinessRepository.save(menteBusiness);}
    @Transactional
    public MentorBusiness MentorBusinessCreate(MentorBusiness mentorBusiness) { return mentorBusinessRepository.save(mentorBusiness);}
}
