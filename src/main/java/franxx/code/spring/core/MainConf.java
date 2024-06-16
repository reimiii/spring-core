package franxx.code.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        BarConf.class,
        FooConf.class
})
public class MainConf {
}
