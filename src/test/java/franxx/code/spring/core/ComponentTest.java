package franxx.code.spring.core;

import franxx.code.spring.core.data.Bar;
import franxx.code.spring.core.data.Foo;
import franxx.code.spring.core.repository.CategoryRepository;
import franxx.code.spring.core.repository.CustomerRepository;
import franxx.code.spring.core.repository.ProductRepository;
import franxx.code.spring.core.service.CategoryService;
import franxx.code.spring.core.service.CustomerService;
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

    @Test
    void depInjSetter() {
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        CategoryService categoryService = context.getBean(CategoryService.class);

        Assertions.assertSame(categoryRepository, categoryService.getRepository());
    }

    @Test
    void depInjField() {
        CustomerService service = context.getBean(CustomerService.class);
        CustomerRepository normal = context.getBean("normalCustomerRepository", CustomerRepository.class);
        CustomerRepository premium = context.getBean("premiumCustomerRepository", CustomerRepository.class);

        Assertions.assertSame(normal, service.getNormalRepository());
        Assertions.assertSame(premium, service.getPremiumRepository());
    }
}
