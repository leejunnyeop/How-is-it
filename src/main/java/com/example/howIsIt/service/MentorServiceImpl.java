package com.example.howIsIt.service;

import com.example.howIsIt.util.EntityFinder;
import com.example.howIsIt.dto.MentorDto;
import com.example.howIsIt.dto.MentorUpdateDto;
import com.example.howIsIt.domain.MentorProfile;
import com.example.howIsIt.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {


    /*
    crud
     */

    private final MentorRepository mentorRepository;
    private final EntityFinder entityFinder;



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
       MentorProfile mentorProfileSave = mentorDto.mentorEntity(mentorDto);
       MentorProfile mentorProfileCreateSave = mentorRepository.save(mentorProfileSave);
        return convertToDto(mentorProfileCreateSave);


    }

    @Override
    public MentorDto infoMentorProfile(Long id) {
        MentorProfile infoMentorProfile = entityFinder.existingProfileId(id);
        return convertToDto(infoMentorProfile);

    }

    @Override
    public MentorUpdateDto updateMentorProfile(Long id, MentorUpdateDto mentorUpdateDto) {
        MentorProfile existingProfile = entityFinder.existingProfileId(id);
        existingProfile.updateProfileFrom(mentorUpdateDto);
        MentorProfile save = mentorRepository.save(existingProfile);
        return updateConvertToDto(save);

    }

    @Override
    public void  deleteMentorProfile(Long id) {
        mentorRepository.deleteById(id);
    }
}
