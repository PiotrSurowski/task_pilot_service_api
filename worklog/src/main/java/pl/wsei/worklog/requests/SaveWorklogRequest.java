package pl.wsei.worklog.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaveWorklogRequest {
    private Integer id;
    private Integer taskId;
    private Integer performerId;
    private Date dateStart;
    private Date dateFinish;
}
