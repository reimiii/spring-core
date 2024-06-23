package franxx.code.spring.core;

import franxx.code.spring.core.data.Bar;
import franxx.code.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {
    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ScopeConf.class);
    }

    @Test
    void create() {
        Foo foo1 = applicationContext.getBean(Foo.class);
        Foo foo2 = applicationContext.getBean(Foo.class);
        Foo foo3 = applicationContext.getBean(Foo.class);

//        Bar bar1 = applicationContext.getBean(Bar.class);
//        Bar bar2 = applicationContext.getBean(Bar.class);

//        Assertions.assertSame(bar1, bar2);

        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertNotSame(foo2, foo3);
        Assertions.assertNotSame(foo1, foo3);

    }

    @Test
    void doubleScope() {
        Bar bar1 = applicationContext.getBean("scope", Bar.class);
        Bar bar2 = applicationContext.getBean("scope", Bar.class);
        Bar bar3 = applicationContext.getBean("scope", Bar.class);
        Bar bar4 = applicationContext.getBean("scope", Bar.class);

        Assertions.assertSame(bar1, bar3);
        Assertions.assertSame(bar2, bar4);

        Assertions.assertNotSame(bar1, bar2);
        Assertions.assertNotSame(bar3, bar4);
    }
}
