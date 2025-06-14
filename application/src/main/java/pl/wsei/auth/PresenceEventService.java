package pl.wsei.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pl.wsei.events.PresenceEndEvent;
import pl.wsei.events.PresenceStartEvent;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class PresenceEventService {
    private final ApplicationEventPublisher eventPublisher;
    public void handleStart(Integer userId) {
        eventPublisher.publishEvent(new PresenceStartEvent(userId));
        Logger.getAnonymousLogger().info("Login event send " + userId);
    }
    public void handleEnd(Integer userId) {
        eventPublisher.publishEvent(new PresenceEndEvent(userId));
        Logger.getAnonymousLogger().info("Logout event send " + userId);
    }
}
