package franxx.code.spring.core.data;

import franxx.code.spring.core.DependencyInjectionConf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertSame;

class FooBarTestDependencyInjectionTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(DependencyInjectionConf.class);
    }

    @Test
    void create() {
        Bar bar = new Bar();
        Foo foo = new Foo();
        var fooBar = new FooBar(foo, bar);

        assertSame(foo, fooBar.getFoo());
        assertSame(bar, fooBar.getBar());
    }

    @Test
    void createWithSpring() {

        Foo foo = context.getBean("fooSecond", Foo.class);
        Bar bar = context.getBean(Bar.class);

        FooBar fooBar = context.getBean(FooBar.class);

        assertSame(foo, fooBar.getFoo());
        assertSame(bar, fooBar.getBar());

    }
}