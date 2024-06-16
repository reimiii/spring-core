package franxx.code.spring.core;

import franxx.code.spring.core.data.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BarConf {
    @Bean
    public Bar bar() {
        return new Bar();
    }
}
