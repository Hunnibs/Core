package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixDiscountPolicyTest {
    FixDiscountPolicy fixDiscountPolicy = new FixDiscountPolicy();

    @Test
    @DisplayName("고정할인 대상자")
    void Vip_O(){
        // given
        Member member = new Member(1L, "Vip_Lee", Grade.VIP);
        // when
        int discount = fixDiscountPolicy.discount(member, 20000);
        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }
}