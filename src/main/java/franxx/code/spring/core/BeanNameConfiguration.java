package franxx.code.spring.core;

import franxx.code.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanNameConfiguration {

    @Primary
    @Bean(name = "first")
    public Foo foo1() {
        return new Foo();
    }

    @Bean(name = "second")
    public Foo foo2() {
        return new Foo();
    }

}
