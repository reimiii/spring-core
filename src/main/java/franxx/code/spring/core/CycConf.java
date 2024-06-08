package franxx.code.spring.core;

import franxx.code.spring.core.data.syc.CycA;
import franxx.code.spring.core.data.syc.CycB;
import franxx.code.spring.core.data.syc.CycC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CycConf {

    @Bean
    public CycA cycA(CycB cycB) {
        return new CycA(cycB);
    }

    @Bean
    public CycB cycB(CycC cycC) {
        return new CycB(cycC);
    }

    @Bean
    public CycC cycC(CycA cycA) {
        return new CycC(cycA);
    }
}
