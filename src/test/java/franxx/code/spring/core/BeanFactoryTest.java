package franxx.code.spring.core;

import franxx.code.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class BeanFactoryTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ScanConf.class);
        context.registerShutdownHook();
    }

    @Test
    void testBeanFactory() {

        ObjectProvider<Foo> fooObjectProvider = context.getBeanProvider(Foo.class);
        List<Foo> fooList = fooObjectProvider.stream().toList();
        System.out.println(fooList);

        Map<String, Foo> beansOfType = context.getBeansOfType(Foo.class);
        System.out.println(beansOfType);

    }
}
