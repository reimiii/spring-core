package franxx.code.spring.core;

import franxx.code.spring.core.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class AwareTest {

    @Configuration
    @Import(AuthService.class)
    public static class AwConf {
    }

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(AwConf.class);
        context.registerShutdownHook();
    }

    @Test
    void create() {
        AuthService contextBean = context.getBean(AuthService.class);
        Assertions.assertEquals("franxx.code.spring.core.service.AuthService", contextBean.getBeanName());
        Assertions.assertNotNull(contextBean.getApplicationContext());
        Assertions.assertSame(context, contextBean.getApplicationContext());
    }
}
