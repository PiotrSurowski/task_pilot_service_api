package pl.wsei.worklog.components;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.wsei.common.events.TaskStatusFinishEvent;
import pl.wsei.common.events.TaskStatusStartEvent;
import pl.wsei.worklog.services.WorkLogService;

@Component
@RequiredArgsConstructor
public class TaskStatusEventHandler {
    private final WorkLogService workLogService;

    @EventListener
    public void handleStatusStart(TaskStatusStartEvent event){
        workLogService.saveTaskStart(event.getTaskId(), event.getPerformerId());
    }

    @EventListener
    public void handleStatusFinish(TaskStatusFinishEvent event){
        workLogService.saveTaskFinish(event.getTaskId(), event.getPerformerId());
    }
}
