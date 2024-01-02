package com.example.howIsIt.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Member createMember(MemberDto memberDto){
        Member entity = memberDto.memberEntity(memberDto);
        return memberRepository.save(entity);

    }
}
