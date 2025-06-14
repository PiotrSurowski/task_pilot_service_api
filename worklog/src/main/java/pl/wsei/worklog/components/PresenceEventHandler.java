package pl.wsei.worklog.components;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.wsei.common.events.PresenceEndEvent;
import pl.wsei.common.events.PresenceStartEvent;
import pl.wsei.worklog.services.PresenceService;

@Component
@RequiredArgsConstructor
public class PresenceEventHandler {
    private final PresenceService presenceService;

    @EventListener
    public void handlePresenceStart(PresenceStartEvent event) {
        presenceService.saveStartPresence(event.getUserId());
    }

    @EventListener
    public void handlePresenceEnd(PresenceEndEvent event) {
        presenceService.saveEndPresence(event.getUserId());
    }
}
