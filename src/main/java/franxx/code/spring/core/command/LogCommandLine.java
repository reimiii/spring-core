package franxx.code.spring.core.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class LogCommandLine implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("Log command line runner: {}", Arrays.toString(args));
    }
}
