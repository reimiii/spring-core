package franxx.code.spring.core.factory;

import franxx.code.spring.core.client.PaymentGatewayClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("payGate")
public class PaymentGatewayFactoryBean implements FactoryBean<PaymentGatewayClient> {
    @Override
    public PaymentGatewayClient getObject() throws Exception {
        return PaymentGatewayClient.of(
                "https:/mee.go",
                "private",
                "public"
        );
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
}
