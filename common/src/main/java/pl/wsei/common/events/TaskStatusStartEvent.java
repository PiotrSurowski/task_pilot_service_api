package pl.wsei.common.events;

public class TaskStatusStartEvent {
    private Integer taskId;
    private Integer performerId;

    public TaskStatusStartEvent(Integer taskId, Integer performerId) {
        this.taskId = taskId;
        this.performerId = performerId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public Integer getPerformerId() {
        return performerId;
    }
}
