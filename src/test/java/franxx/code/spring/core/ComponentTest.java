package franxx.code.spring.core;

import franxx.code.spring.core.data.Bar;
import franxx.code.spring.core.data.Foo;
import franxx.code.spring.core.repository.ProductRepository;
import franxx.code.spring.core.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ComponentConf.class);
        context.registerShutdownHook();
    }

    @Test
    void create() {
        ProductService service = context.getBean(ProductService.class);
        ProductService productService = context.getBean("productService", ProductService.class);

        Assertions.assertSame(service, productService);
    }

    @Test
    void dependencyInjectionComponent() {
        ProductService productService = context.getBean(ProductService.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Assertions.assertSame(productRepository, productService.getRepository());
    }
}
