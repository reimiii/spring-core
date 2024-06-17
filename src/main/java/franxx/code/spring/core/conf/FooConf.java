package franxx.code.spring.core.conf;

import franxx.code.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooConf {
    @Bean
    public Foo foo() {
        return new Foo();
    }
}
