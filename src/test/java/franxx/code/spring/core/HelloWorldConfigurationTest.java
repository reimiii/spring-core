package franxx.code.spring.core;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldConfigurationTest {

    @Test
    void create() {

        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        assertNotNull(context);
    }
}