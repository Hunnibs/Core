package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{
    private int RateDiscount = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            // problem? 할인율은 int형으로 표현이 불가능
            return price * RateDiscount / 100;
        } else {
            return 0;
        }
    }
}
