package franxx.code.spring.core;

import franxx.code.spring.core.listener.LoginSuccesListener;
import franxx.code.spring.core.service.UserSevice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListenerTest {
    @Configuration
    @Import({
            UserSevice.class,
            LoginSuccesListener.class
    })
    static class ConfEvent {
    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ConfEvent.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testEventListener() {
        UserSevice userSevice = applicationContext.getBean(UserSevice.class);
        userSevice.login("me", "me");
        userSevice.login("salah", "salah");
    }
}
