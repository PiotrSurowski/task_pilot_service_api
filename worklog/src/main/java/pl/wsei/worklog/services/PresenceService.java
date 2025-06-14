package pl.wsei.worklog.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsei.worklog.entities.Presence;
import pl.wsei.worklog.repositories.PresenceRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PresenceService {
    private final PresenceRepository presenceRepository;

    public void saveStartPresence(Integer userId) {
        LocalDate today = LocalDate.now();
        Date startOfDay = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endOfDay = Date.from(today.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

        boolean alreadyStarted = presenceRepository.existsByUserIdAndDateStartBetweenAndDateFinishIsNull(
                userId, startOfDay, endOfDay
        );

        if (!alreadyStarted) {
            Presence presence = Presence.builder()
                    .userId(userId)
                    .dateStart(new Date())
                    .build();

            presenceRepository.save(presence);
        }
    }
    public void saveEndPresence(Integer userId) {
        System.out.println(">>> saveEndPresence() - szukam obecności dla userId = " + userId);

        LocalDate today = LocalDate.now();
        Date startOfDay = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endOfDay = Date.from(today.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

        Optional<Presence> optionalPresence = presenceRepository
                .findFirstByUserIdAndDateStartBetweenAndDateFinishIsNullOrderByDateStartDesc(
                        userId, startOfDay, endOfDay);

        if (optionalPresence.isPresent()) {
            System.out.println(">>> Znaleziono obecność, ustawiam date_finish");
            Presence presence = optionalPresence.get();
            presence.setDateFinish(new Date());
            presenceRepository.save(presence);
        } else {
            System.out.println(">>> Brak aktywnej obecności do zakończenia (null)");
        }
    }


}
