package franxx.code.spring.core.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class PaymentGatewayClient {

    private String endPoint;

    private String privateKey;

    private String publicKey;
}
