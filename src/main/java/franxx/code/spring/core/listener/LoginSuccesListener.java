package franxx.code.spring.core.listener;

import franxx.code.spring.core.event.LoginSuccesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginSuccesListener implements ApplicationListener<LoginSuccesEvent> {
    @Override
    public void onApplicationEvent(LoginSuccesEvent event) {
        log.info("success login for user {}", event.getUser());
    }
}
