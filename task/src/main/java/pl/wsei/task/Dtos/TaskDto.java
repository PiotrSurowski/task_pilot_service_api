package pl.wsei.task.Dtos;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDto {
    private Integer id;
    private String description;
    private String title;
    private Integer performerId;
    private Integer statusId;
}
