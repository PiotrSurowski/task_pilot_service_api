package pl.wsei.task.enums;

import java.util.Arrays;

public enum TaskStatus {
    NEW(1),
    STARTED(2),
    FINISHED(3);

    TaskStatus(int id) {
        this.id = id;
    }
    private final Integer id;

    public static TaskStatus getStatusById(int id){
        return Arrays.stream(TaskStatus.values()).filter(status -> id == status.getId())
                .findFirst()
                .orElse(null);
    }
    public Integer getId() {
        return id;
    }
    @Override
    public String toString() {
        return name();
    }
}
