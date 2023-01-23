package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member member = new Member(1L, "Lee", Grade.VIP);
        memberService.join(member);

        Order order = orderService.CreateOrder(1L, "Note", 20000);
        System.out.println("order = " + order.toString());
        System.out.println("order = " + order.CalculatePrice());
    }
}
