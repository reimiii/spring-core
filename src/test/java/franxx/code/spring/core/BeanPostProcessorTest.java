package franxx.code.spring.core;

import franxx.code.spring.core.data.Car;
import franxx.code.spring.core.processor.IdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class BeanPostProcessorTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class

    })
    public static class TestConf {

    }

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(TestConf.class);
        context.registerShutdownHook();
    }

    @Test
    void testCar() {
        Car car = context.getBean(Car.class);
        System.out.println(car.getId());

        Assertions.assertNotNull(car.getId());
    }
}
