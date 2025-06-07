package pl.wsei.worklog.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WorkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "task_id")
    private Integer taskId;
    @Column(name = "performer_id")
    private Integer performerId;
    @Column(name = "date_start")
    private Date dateStart;
    @Column(name = "date_finish")
    private Date dateFinish;
    @Transient
    public Long getrSpendTime(){
        if (dateStart == null || dateFinish == null) return null;
        long diffInMillies = dateFinish.getTime() - dateStart.getTime();
        return TimeUnit.MILLISECONDS.toMinutes(diffInMillies);
    }
}
