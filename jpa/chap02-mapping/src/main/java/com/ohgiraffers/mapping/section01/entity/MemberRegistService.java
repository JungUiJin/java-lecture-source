package com.ohgiraffers.mapping.section01.entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberRegistService {
    private MemberRepository memberRepository;
    public MemberRegistService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void registerMember(MemberRegistDTO newMember) {

        Member member = new Member(
                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRole(),
                newMember.getStatus()
        );

        memberRepository.save(member);
    }


    /* Spring의 트랜잭션 전파 방식(default : PROPAGATION_REQUIRED) 에 따하
    * @Transactional이 붙은 메소드가 다른 @Transactional이 붙은 메소드를 호출하면,
    * 호출 된 메소드는 호출한 메소드와 동일한 트랜잭션 컨텍스트를 사용한다. */
    @Transactional
    public String registMemberAndFindName(MemberRegistDTO newMember) {
        registerMember(newMember);
        return memberRepository.findNameById(newMember.getMemberId());
    }
}
