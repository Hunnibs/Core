package hello.core.sigleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SigletonTest {
    @Test
    @DisplayName("스프링 없는 순순한 DI 컨테이너")
    void pureContainer() {
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService1 = appConfig.memberService();
//        MemberService memberService2 = appConfig.memberService();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean(MemberService.class);
        MemberService memberService2 = ac.getBean(MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService 객체를 요청할 때마다 새로운 것을 만들어서 전달해줌 -> 계속해서 새로운 객체가 생성되기 때문에 다르게 나오게 된다.
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}

