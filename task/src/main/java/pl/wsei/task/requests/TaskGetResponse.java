package pl.wsei.task.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.wsei.task.Dtos.TaskDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskGetResponse {
    private List<TaskDto> tasks;
}
