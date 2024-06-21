package franxx.code.spring.core;

import franxx.code.spring.core.service.MerService;
import franxx.code.spring.core.service.MerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class InheritanceConfTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(InheritanceConf.class);
        context.registerShutdownHook();
    }

    @Test
    void create() {
        MerServiceImpl merService = context.getBean(MerServiceImpl.class);
        MerService service = context.getBean(MerService.class);

        assertSame(merService, service);
    }
}