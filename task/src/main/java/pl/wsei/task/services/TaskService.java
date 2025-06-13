package pl.wsei.task.services;

import pl.wsei.task.Dtos.TaskDto;
import pl.wsei.task.entities.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsei.task.repositories.TaskRepository;
import pl.wsei.task.requests.CreateTaskRequest;
import pl.wsei.task.requests.TaskCreationResponse;
import pl.wsei.task.requests.TaskGetResponse;
import pl.wsei.task.requests.TaskUpdateRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public TaskGetResponse getTasksByUser(Integer userId){
        List<Task> tasks = taskRepository.findAllByPerformerId(userId);
        List<TaskDto> taskDtos = tasks.stream()
                .map(task -> TaskDto.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .performerId(task.getPerformerId())
                        .build())
                .toList();
        return new TaskGetResponse(taskDtos);
    }
    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }

    public boolean updateTask(TaskUpdateRequest request) {
        return taskRepository.findById(request.getId())
                .map(task -> {
                    task.setStatus(request.getStatusId());
                    return true;
                })
                .orElse(false);
    }
}
