package franxx.code.spring.core;

import franxx.code.spring.core.factory.PaymentGatewayFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PaymentGatewayFactoryBean.class)
public class FactoryConf {
}
