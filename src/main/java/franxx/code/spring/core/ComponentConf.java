package franxx.code.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "franxx.code.spring.core.service"
})
public class ComponentConf {
}
