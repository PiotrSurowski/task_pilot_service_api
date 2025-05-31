package pl.wsei.worklog.DTO;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class WorkLogDto {
    private Integer id;
    private Integer taskId;
    private Integer performerId;
    private Date dateStart;
    private Date dateFinish;
}
