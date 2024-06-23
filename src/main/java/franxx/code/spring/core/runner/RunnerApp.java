package franxx.code.spring.core.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class RunnerApp {

    public static void main(String[] args) {
        SpringApplication.run(RunnerApp.class, args);
    }

    @Slf4j
    @Component
    static class SimpleRun implements ApplicationRunner {
        @Override
        public void run(ApplicationArguments args) throws Exception {
            List<String> profiles = args.getOptionValues("profiles");
            log.info("Profiles: {}", profiles);
        }
    }
}
