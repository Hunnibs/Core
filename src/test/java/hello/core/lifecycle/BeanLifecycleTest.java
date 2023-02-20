package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {
    @Test
    public void lifecycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfig.class);

        NetworkClient networkClient = ac.getBean(NetworkClient.class);
//        networkClient.call("불러오기 완료");
//        networkClient.disconnect();
        ac.close();
    }

    @Configuration
    static class LifecycleConfig{
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://Core-Spring.dev");
            return networkClient;
        }
    }
}
