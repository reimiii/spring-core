package franxx.code.spring.core;

import franxx.code.spring.core.service.MerServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MerServiceImpl.class)
public class InheritanceConf {
}
