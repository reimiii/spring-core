package franxx.code.spring.core;

import franxx.code.spring.core.data.Bar;
import franxx.code.spring.core.data.Foo;
import franxx.code.spring.core.scope.DoubleScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class ScopeConf {

    @Bean
    @Scope("prototype")
    public Foo foo() {
        log.info("Creating Foo");
        return new Foo();
    }

    @Bean
    @Scope("singleton") // default
    public Bar bar() {
        log.info("Creating Bar");
        return new Bar();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("double", new DoubleScope());
        return configurer;
    }

    @Bean(name = "scope")
    @Scope("double")
    public Bar barScope() {
        log.info("Create bar scope");
        return new Bar();
    }
}
