package com.example.howIsIt.mentos.service;

import com.example.howIsIt.mentos.domain.dto.MentorDto;
import com.example.howIsIt.mentos.repository.MentosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MentorService {

    private final MentosRepository mentosRepository;

    private final MentorDto mentorDto;

    /*
    멘토 게시판 crud
     */

}
