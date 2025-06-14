package pl.wsei.worklog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsei.worklog.entities.Presence;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PresenceRepository extends JpaRepository<Presence, Integer> {
    boolean existsByUserIdAndDateStartBetweenAndDateFinishIsNull(
            Integer userId, Date start, Date end
    );

    Optional<Presence> findFirstByUserIdAndDateStartBetweenAndDateFinishIsNullOrderByDateStartDesc(
            Integer userId, Date start, Date end
    );
}
