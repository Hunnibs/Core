package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

    @Test
    void findAllBean(){
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member lee = new Member(1L, "Lee", Grade.VIP);
        int discountPrice = discountService.discount(lee, 10000, "rateDiscountPolicy");

        assertThat(discountPrice).isEqualTo(1000);
        assertThat(discountService).isInstanceOf(DiscountService.class);
    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }

        public int discount(Member member, int price, String discountCode){
            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            System.out.println("discountPolicy = " + discountPolicy);
            System.out.println("discountCode = " + discountCode);

            return discountPolicy.discount(member, price);
        }
    }
}
