package pl.wsei.worklog.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.wsei.worklog.requests.LogoutRequest;
import pl.wsei.worklog.services.PresenceService;

@RestController
@RequestMapping("/api/presence")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PresenceController {
    private final PresenceService service;
    @PostMapping("/logout")
    public void logout(@RequestBody LogoutRequest logoutRequest){
        service.saveEndPresence(logoutRequest.getUserId());
    }
}
