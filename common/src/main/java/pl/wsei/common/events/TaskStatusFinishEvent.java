package pl.wsei.common.events;

public class TaskStatusFinishEvent {
    private Integer taskId;
    private Integer performerId;

    public TaskStatusFinishEvent(Integer taskId, Integer performerId) {
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
