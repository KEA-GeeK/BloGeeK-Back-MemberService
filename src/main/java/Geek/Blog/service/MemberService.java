package Geek.Blog.service;

import Geek.Blog.entity.Member;
import Geek.Blog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // Todo: Member Class 대신 LoginReqDto 받아서 id를 기반으로 사용자 조회하고 로그인 처리하도록 수정
    public Member login(Member member) throws Exception {
        return memberRepository.findByEmail(member.getEmail())
                .orElseThrow(() -> new Exception("존재하지 않는 사용자"));
    }


}

