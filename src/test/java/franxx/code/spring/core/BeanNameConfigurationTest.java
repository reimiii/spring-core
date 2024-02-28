package franxx.code.spring.core;

import franxx.code.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class BeanNameConfigurationTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
    }

    @Test
    void create() {
        Foo primary = context.getBean(Foo.class);
        Foo foo1 = context.getBean("first", Foo.class);
        Foo foo2 = context.getBean("second", Foo.class);

        assertSame(primary, foo1);
        assertNotSame(primary, foo2);
        assertNotSame(foo1, foo2);
    }
}