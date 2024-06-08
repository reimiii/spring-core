package franxx.code.spring.core;

import franxx.code.spring.core.data.Bar;
import franxx.code.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class DependsOnConf {

    @Lazy
    @Bean
    @DependsOn("bar")
    public Foo foo() {
        log.info("Creating Foo");
        return new Foo();
    }

    @Bean
    public Bar bar() {
        log.info("Creating Bar");
        return new Bar();
    }
}
