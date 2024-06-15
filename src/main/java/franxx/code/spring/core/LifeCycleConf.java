package franxx.code.spring.core;

import franxx.code.spring.core.data.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConf {

    @Bean
    public Connection connection() {
        return new Connection();
    }
}
