package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

public class FixDiscountPolicy implements DiscountPolicy{
    private int FixDiscount = 1000; // 고정 할인 금액: 1000원

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){ // why? VIP로 쓰면 안되는 이유
            return FixDiscount;
        }else{
            return 0;
        }
    }
}
