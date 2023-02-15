package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    @Test
    void AutowiredOption(){

    }

    static class TestBean{
        @Autowired(required = false)
        public void SetNoBean1(Member member){
            System.out.println("member1 = " + member);
        }

        @Autowired
        public void SetNoBean2(@Nullable Member member){
            System.out.println("member2 = " + member);
        }

        @Autowired
        public void SetNoBean3(Optional<Member> member){
            System.out.println("member3 = " + member);
        }
    }
}
