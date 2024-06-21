package franxx.code.spring.core;

import franxx.code.spring.core.client.PaymentGatewayClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(FactoryConf.class);
        context.registerShutdownHook();
    }

    @Test
    void create() {
        PaymentGatewayClient client = context.getBean(PaymentGatewayClient.class);

        assertNotNull(client);
        assertEquals("public", client.getPublicKey());
        assertEquals("private", client.getPrivateKey());

    }
}
