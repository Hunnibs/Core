package hello.core.Member;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {
//    MemberService memberService;
//
//    public MemberServiceTest(MemberService memberService) {
//        this.memberService = memberService;
//    }

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void join(){
        MemberService memberService = ac.getBean(MemberService.class);

        //given
        Member member = new Member(1L, "Lee", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
