package hello.core.Order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void CreateOrder(){
        Member member = new Member(1L, "Lee", Grade.VIP);
        memberService.join(member);

        Order order = orderService.CreateOrder(member.getId(), "keyboard", 10000);
        Assertions.assertThat(order.getDiscount()).isEqualTo(1000);
    }
}
