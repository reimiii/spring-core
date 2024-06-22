package franxx.code.spring.core.processor;

import franxx.code.spring.core.aware.IdAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class FranXXIdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("FranXX id generator for bean {}", beanName);
        if (bean instanceof IdAware) {
            log.info("FranXX set id for bean {}", beanName);
            IdAware idAware = (IdAware) bean;
            idAware.setId("FranXX-" + idAware.getId());
        }

        return bean;
    }

}
