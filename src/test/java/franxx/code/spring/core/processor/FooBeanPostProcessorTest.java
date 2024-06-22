package franxx.code.spring.core.processor;

import franxx.code.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

class FooBeanPostProcessorTest {

    @Configuration
    @Import(FooBeanPostProcessor.class)
    static class Conf {
    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(Conf.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void create() {
        Foo foo = applicationContext.getBean(Foo.class);
        assertNotNull(foo);
    }
}