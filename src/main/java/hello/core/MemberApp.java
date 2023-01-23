package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member memberA = new Member(1L, "Lee", Grade.VIP);
        memberService.join(memberA);

        Member findMemberA = memberService.findMember(1L);
        System.out.println("findMemberA = " + findMemberA.getName());
        System.out.println("memberA = " + memberA.getName());
    }
}
