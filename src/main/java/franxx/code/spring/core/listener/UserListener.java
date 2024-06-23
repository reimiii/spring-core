package franxx.code.spring.core.listener;

import franxx.code.spring.core.event.LoginSuccesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserListener {

    @EventListener(classes = LoginSuccesEvent.class)
    public void onLoginSuccessEvent(LoginSuccesEvent event) {
        log.info("success login for user {}", event.getUser());
    }

    @EventListener(classes = LoginSuccesEvent.class)
    public void onLoginSuccessEvent1(LoginSuccesEvent event) {
        log.info("success login for user {}", event.getUser());
    }

    @EventListener(classes = LoginSuccesEvent.class)
    public void onLoginSuccessEvent2(LoginSuccesEvent event) {
        log.info("success login for user {}", event.getUser());
    }

}
