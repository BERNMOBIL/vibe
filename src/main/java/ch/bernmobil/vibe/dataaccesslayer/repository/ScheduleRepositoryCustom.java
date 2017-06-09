package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entity.Stop;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Provides a extension to the {@link ScheduleRepository}.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Repository
public interface ScheduleRepositoryCustom {
    /**
     * Find a {@link Page} of {@link Schedule} by its {@link Stop}, sorted by its {@link Schedule#plannedDeparture}.
     * @param stop from which the departures are searched.
     * @param time which is used to sort and filter.
     * @param timestamp of the current valid version of schedule data.
     * @param pageable containing page number and size.
     * @return {@link Page} of {@link Schedule}.
     */
    Page<Schedule> findSchedulesByStop(Stop stop, LocalTime time, LocalDateTime timestamp, Pageable pageable);
}
