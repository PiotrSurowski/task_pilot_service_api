package pl.wsei.worklog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsei.worklog.entities.WorkLog;

@Repository
public interface WorkLogRepository extends JpaRepository<WorkLog, Integer> {
}
