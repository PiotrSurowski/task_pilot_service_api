package pl.wsei.worklog.controllers;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsei.worklog.DTO.WorkLogDto;
import pl.wsei.worklog.requests.SaveWorklogRequest;
import pl.wsei.worklog.requests.WorkLogCreationResponse;
import pl.wsei.worklog.services.WorkLogService;

@RestController
@RequestMapping("/api/work-log")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WorkLogController {
    private final WorkLogService workLogService;

    @PostMapping
    public ResponseEntity<WorkLogCreationResponse> createWorkLog(@RequestBody SaveWorklogRequest request) {
        WorkLogCreationResponse response = workLogService.saveWorkLog(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<WorkLogDto> getWorkLog(@PathVariable Integer id) {
        return workLogService.findWorkLog(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/")
    public ResponseEntity<Void> updateWorkLog(@RequestBody SaveWorklogRequest request) {
        try {
            workLogService.updateWorkLog(request);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWorkLog(@PathVariable Integer id) {
        workLogService.deleteWorkLog(id);
        return ResponseEntity.noContent().build();
    }
}
