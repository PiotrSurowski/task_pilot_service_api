package pl.wsei.task.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pl.wsei.common.events.TaskStatusFinishEvent;
import pl.wsei.common.events.TaskStatusStartEvent;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class TaskStatusEventService {
    private final ApplicationEventPublisher eventPublisher;

    public void handleStart(Integer taskId, Integer userId) {
        eventPublisher.publishEvent(new TaskStatusStartEvent(taskId, userId));
        Logger.getAnonymousLogger().info("Task change event send " + userId);
    }
    public void handleEnd(Integer taskId, Integer userId) {
        eventPublisher.publishEvent(new TaskStatusFinishEvent(taskId, userId));
        Logger.getAnonymousLogger().info("Task change " + userId);
    }
}
