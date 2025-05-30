package pl.wsei.task.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTaskRequest {
    private String description;
    private String title;
    private Integer performerId;
}
