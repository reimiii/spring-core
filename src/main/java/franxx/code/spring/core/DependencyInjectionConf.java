package franxx.code.spring.core;

import franxx.code.spring.core.data.Bar;
import franxx.code.spring.core.data.Foo;
import franxx.code.spring.core.data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class DependencyInjectionConf {
    @Primary
    @Bean
    public Foo fooFirst() {
        return new Foo();
    }

    @Bean
    public Foo fooSecond() {
        return new Foo();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar) {
        return new FooBar(foo, bar);
    }
}
