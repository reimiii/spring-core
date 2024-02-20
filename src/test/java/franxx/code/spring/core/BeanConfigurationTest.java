package franxx.code.spring.core;

import franxx.code.spring.core.data.Foo;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class BeanConfigurationTest {

    @Test
    void beanCreate() {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        assertNotNull(context);
    }

    @Test
    void getBean() {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        assertNotNull(context);

        Foo bean1 = context.getBean(Foo.class);
        Foo bean2 = context.getBean(Foo.class);

        assertSame(bean1, bean2);
    }

}