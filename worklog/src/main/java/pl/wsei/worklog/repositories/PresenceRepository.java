package pl.wsei.worklog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query("SELECT p FROM Presence p " +
            "WHERE p.userId = :userId " +
            "AND p.dateFinish IS NULL " +
            "AND p.dateStart >= :startOfDay AND p.dateStart < :endOfDay " +
            "ORDER BY p.dateStart DESC")
    Optional<Presence> findLatestUnfinishedPresenceToday(
            @Param("userId") Integer userId,
            @Param("startOfDay") Date startOfDay,
            @Param("endOfDay") Date endOfDay
    );

}
