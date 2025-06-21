package pl.wsei.task.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.wsei.task.enums.TaskStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskUpdateRequest {
    private Integer id;
    private Integer statusId;
    private Integer performerId;
}
