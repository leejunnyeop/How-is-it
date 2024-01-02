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

    public MentorProfile existingMentorProfileId(Long id){
        return mentorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("없는 멘토 입니다"));
    }


    public MentorDto convertToDto(MentorProfile mentorProfile){
        return new MentorDto(mentorProfile.getTitle(),
                mentorProfile.getContent(), mentorProfile.getThumbnail(),
                mentorProfile.getExpertise(), mentorProfile.getPrice());
    }

    public MentorUpdateDto updateConvertToDto(MentorProfile mentorProfile){
        return new MentorUpdateDto(mentorProfile.getTitle(),
                mentorProfile.getContent(), mentorProfile.getThumbnail(),
                mentorProfile.getExpertise(), mentorProfile.getPrice());
    }

    @Override
    public MentorDto createMentorProfile(MentorDto mentorDto) {
        log.info("createMentorProfile : 메소드 실행");
       MentorProfile mentorProfileSave = mentorDto.mentorEntity(mentorDto);
       log.info("mentorProfileSave 저장됨");
       MentorProfile mentorProfileCreateSave = mentorRepository.save(mentorProfileSave);
        return convertToDto(mentorProfileCreateSave);


    }

    @Override
    public MentorDto infoMentorProfile(Long id) {
        log.info("조회 메소드 실행");
        MentorProfile infoMentorProfile = existingMentorProfileId(id);
        log.info("조회 완료");
        return convertToDto(infoMentorProfile);

    }

    @Override
    public MentorUpdateDto updateMentorProfile(Long id, MentorUpdateDto mentorUpdateDto) {
        MentorProfile existingProfile = existingMentorProfileId(id);
        existingProfile.updateProfileFrom(mentorUpdateDto);
        MentorProfile save = mentorRepository.save(existingProfile);
        return updateConvertToDto(save);

    }

    @Override
    public void  deleteMentorProfile(Long id) {
        mentorRepository.deleteById(id);
    }
}
