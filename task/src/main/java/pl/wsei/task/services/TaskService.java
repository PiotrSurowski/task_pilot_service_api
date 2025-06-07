package pl.wsei.task.services;

import pl.wsei.task.entities.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsei.task.repositories.TaskRepository;
import pl.wsei.task.requests.CreateTaskRequest;
import pl.wsei.task.requests.TaskCreationResponse;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskCreationResponse register(CreateTaskRequest taskRequest) {
        Task task = Task.builder()
                        .title(taskRequest.getTitle())
                                .description(taskRequest.getDescription())
                                        .performerId(taskRequest.getPerformerId())
                                                .build();
        Task savedTask = taskRepository.save(task);

        return new TaskCreationResponse(savedTask.getId());
    }
}
