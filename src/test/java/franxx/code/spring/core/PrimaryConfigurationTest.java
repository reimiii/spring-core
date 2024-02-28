package franxx.code.spring.core;

import franxx.code.spring.core.data.Foo;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class PrimaryConfigurationTest {
    @Test
    void primary() {


        ApplicationContext context = new AnnotationConfigApplicationContext(PrimaryConfiguration.class);

        Foo primary = context.getBean(Foo.class);
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        assertSame(primary, foo1);
        assertNotSame(primary, foo2);
        assertNotSame(foo1, foo2);

    }
}