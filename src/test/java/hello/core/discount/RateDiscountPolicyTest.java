package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("Vip 할인 적용 대상자")
    void Vip_O(){
        // giver
        Member member = new Member(1L, "Vip_Lee", Grade.VIP);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Vip 할인 적용 미대상자")
    void Vip_X(){
        // giver
        Member member = new Member(1L, "Vip_Lee", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}