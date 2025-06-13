package pl.wsei.task.controlloers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsei.task.requests.CreateTaskRequest;
import pl.wsei.task.requests.TaskCreationResponse;
import pl.wsei.task.requests.TaskGetResponse;
import pl.wsei.task.requests.TaskUpdateRequest;
import pl.wsei.task.services.TaskService;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskCreationResponse> createTask(
            @RequestBody CreateTaskRequest request
    ) {
        return ResponseEntity.ok(taskService.register(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/performer/{id}")
    public ResponseEntity<TaskGetResponse> getTasksByPerformer(@PathVariable Integer id) {
        TaskGetResponse tasks = taskService.getTasksByUser(id);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateTask(@RequestBody TaskUpdateRequest request) {
        boolean updated = taskService.updateTask(request);

        if (updated) {
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }
    }
}
