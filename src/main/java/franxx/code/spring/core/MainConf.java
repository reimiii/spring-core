package franxx.code.spring.core;

import franxx.code.spring.core.conf.BarConf;
import franxx.code.spring.core.conf.FooConf;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        BarConf.class,
        FooConf.class
})
public class MainConf {
}
