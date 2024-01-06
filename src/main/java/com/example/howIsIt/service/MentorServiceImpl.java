package com.example.howIsIt.service;

import com.example.howIsIt.util.EntityFinder;
import com.example.howIsIt.dto.ProfileBoardDto;
import com.example.howIsIt.dto.MentorUpdateDto;
import com.example.howIsIt.domain.ProfileBoard;
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



    public ProfileBoardDto convertToDto(ProfileBoard profileBoard){
        return new ProfileBoardDto(profileBoard.getTitle(),
                profileBoard.getContent(), profileBoard.getThumbnail(),
                profileBoard.getExpertise(), profileBoard.getPrice());
    }

    public MentorUpdateDto updateConvertToDto(ProfileBoard profileBoard){
        return new MentorUpdateDto(profileBoard.getTitle(),
                profileBoard.getContent(), profileBoard.getThumbnail(),
                profileBoard.getExpertise(), profileBoard.getPrice());
    }

    @Override
    public ProfileBoardDto createprofileBoard(ProfileBoardDto profileBoardDto) {
       ProfileBoard profileBoardSave = profileBoardDto.mentorEntity(profileBoardDto);
       ProfileBoard profileBoardCreateSave = mentorRepository.save(profileBoardSave);
        return convertToDto(profileBoardCreateSave);


    }

    @Override
    public ProfileBoardDto infoprofileBoard(Long id) {
        ProfileBoard infoprofileBoard = entityFinder.existingProfileId(id);
        return convertToDto(infoprofileBoard);

    }

    @Override
    public MentorUpdateDto updateprofileBoard(Long id, MentorUpdateDto mentorUpdateDto) {
        ProfileBoard existingProfile = entityFinder.existingProfileId(id);
        existingProfile.updateProfileFrom(mentorUpdateDto);
        ProfileBoard save = mentorRepository.save(existingProfile);
        return updateConvertToDto(save);

    }

    @Override
    public void  deleteprofileBoard(Long id) {
        mentorRepository.deleteById(id);
    }
}
