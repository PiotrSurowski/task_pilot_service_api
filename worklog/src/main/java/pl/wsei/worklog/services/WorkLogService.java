package pl.wsei.worklog.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsei.worklog.DTO.WorkLogDto;
import pl.wsei.worklog.entities.WorkLog;
import pl.wsei.worklog.repositories.WorkLogRepository;
import pl.wsei.worklog.requests.SaveWorklogRequest;
import pl.wsei.worklog.requests.WorkLogCreationResponse;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class WorkLogService {
    private final WorkLogRepository workLogRepository;

    public WorkLogCreationResponse saveWorkLog(SaveWorklogRequest request){
        WorkLog workLog = WorkLog.builder()
                .performerId(request.getPerformerId())
                .taskId(request.getTaskId())
                .dateStart(request.getDateStart())
                .dateFinish(request.getDateFinish())
                .build();

        WorkLog savedWorkLog = workLogRepository.save(workLog);
        return new WorkLogCreationResponse(savedWorkLog.getId());
    }

    public Optional<WorkLogDto> findWorkLog(Integer id) {
        return workLogRepository.findById(id)
                .map(log -> WorkLogDto.builder()
                        .id(log.getId())
                        .taskId(log.getTaskId())
                        .performerId(log.getPerformerId())
                        .dateStart(log.getDateStart())
                        .dateFinish(log.getDateFinish())
                        .build());
    }

    public void updateWorkLog(SaveWorklogRequest request) {
        WorkLog existingWorkLog = workLogRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("WorkLog with id " + (request.getId() != null ? request.getId() : 0) + " not found"));

        existingWorkLog.setPerformerId(request.getPerformerId());
        existingWorkLog.setTaskId(request.getTaskId());
        existingWorkLog.setDateStart(request.getDateStart());
        existingWorkLog.setDateFinish(request.getDateFinish());

        workLogRepository.save(existingWorkLog);
    }

    public void saveTaskStart(Integer taskId, Integer performerId) {
        WorkLog workLog = workLogRepository
                .findByTaskIdAndPerformerId(taskId, performerId)
                .orElseGet(() -> WorkLog.builder()
                        .taskId(taskId)
                        .performerId(performerId)
                        .build());

        workLog.setDateStart(new Date());
        workLogRepository.save(workLog);
    }

    public void saveTaskFinish(Integer taskId, Integer performerId) {
        WorkLog workLog = workLogRepository
                .findByTaskIdAndPerformerId(taskId, performerId)
                .orElseGet(() -> WorkLog.builder()
                        .taskId(taskId)
                        .performerId(performerId)
                        .build());

        workLog.setDateFinish(new Date());
        workLogRepository.save(workLog);
    }

    public void deleteWorkLog(Integer id){
        this.workLogRepository.deleteById(id);
        this.workLogRepository.flush();
    }
}
