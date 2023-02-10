package hello.core.sigleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void StatefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int LeeOrderPrice = statefulService1.order("Lee", 10000);
        int ParkOrderPrice = statefulService2.order("Park", 50000);
//        필드를 공유하는 경우 발생하는 에러 테스트
//        Assertions.assertThat(statefulService1.getPrice()).isNotEqualTo(10000);
        assertThat(LeeOrderPrice).isEqualTo(10000);
        assertThat(ParkOrderPrice).isEqualTo(50000);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}