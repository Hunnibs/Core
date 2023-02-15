package hello.core.Order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {
//    MemberService memberService;
//    OrderService orderService;

    //    public OrderServiceTest(MemberService memberService, OrderService orderService) {
//        this.memberService = memberService;
//        this.orderService = orderService;
//    }

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void CreateOrder(){
        MemberService memberService = ac.getBean(MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);

        Member member = new Member(1L, "Lee", Grade.VIP);
        memberService.join(member);

        Order order = orderService.CreateOrder(member.getId(), "keyboard", 10000);
        Assertions.assertThat(order.getDiscount()).isEqualTo(1000);
    }
}
