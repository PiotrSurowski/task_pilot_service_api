package pl.wsei.worklog.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsei.worklog.requests.LogoutRequest;
import pl.wsei.worklog.services.PresenceService;

@RestController
@RequestMapping("/api/presence")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PresenceController {
    private final PresenceService service;
    @PostMapping("/logout")
    public void logout(LogoutRequest logoutRequest){
        service.saveEndPresence(logoutRequest.getUserId());
    }
}
