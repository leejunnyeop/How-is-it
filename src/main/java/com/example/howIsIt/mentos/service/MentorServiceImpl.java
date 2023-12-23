package com.example.howIsIt.mentos.service;

import com.example.howIsIt.mentos.domain.dto.MentorDto;
import com.example.howIsIt.mentos.domain.dto.MentorUpdateDto;
import com.example.howIsIt.mentos.domain.entity.MentorProfile;
import com.example.howIsIt.mentos.repository.MentorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MentorServiceImpl implements MentorService {


    /*
    crud
     */

    private final MentorRepository mentorRepository;

    @Override
    public MentorProfile mentorProfileId(Long id){
        return mentorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("없는 멘토 입니다"));
    }

    @Override
    public MentorProfile createMentorProfile(MentorDto mentorDto) {
        log.info("createMentorProfile : 메소드 실행");
       MentorProfile mentorProfileSave = mentorDto.mentorEntity(mentorDto);
       log.info("mentorProfileSave 저장됨");
       MentorProfile mentorProfileCreateSave = mentorRepository.save(mentorProfileSave);
       return mentorProfileCreateSave;

    }

    @Override
    public MentorProfile infoMentorProfile(Long id) {
        log.info("조회 메소드 실행");
        MentorProfile infoMentorProfile = mentorProfileId(id);
        log.info("조회 완료");
        return infoMentorProfile;

    }

    @Override
    public MentorProfile updateMentorProfile(Long id, MentorUpdateDto mentorUpdateDto) {
        MentorProfile existingProfile = mentorProfileId(id);
        existingProfile.updateProfileFrom(mentorUpdateDto);
        MentorProfile save = mentorRepository.save(existingProfile);
        return save;

    }

    @Override
    public void  deleteMentorProfile(Long id) {
        mentorRepository.deleteById(id);
    }
}
