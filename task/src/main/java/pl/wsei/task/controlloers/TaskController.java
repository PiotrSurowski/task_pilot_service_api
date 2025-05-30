package pl.wsei.task.controlloers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsei.task.requests.CreateTaskRequest;
import pl.wsei.task.requests.TaskCreationResponse;
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

    @GetMapping("/test")
    public String getTest(){
        return "Task endpoint";
    }
}
