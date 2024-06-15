package franxx.code.spring.core;

import franxx.code.spring.core.data.Connection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(LifeCycleConf.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void create() {
        Connection bean = applicationContext.getBean(Connection.class);
    }
}
