package franxx.code.spring.core.service;

import franxx.code.spring.core.data.User;
import franxx.code.spring.core.event.LoginSuccesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserSevice implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public boolean login(String username, String password) {
        if (isLoginValid(username, password)) {
            eventPublisher.publishEvent(new LoginSuccesEvent(User.of(username)));
            return true;
        } else {
            return false;
        }
    }

    private boolean isLoginValid(String username, String password) {
        return "me".equals(username) && "me".equals(password);
    }
}
