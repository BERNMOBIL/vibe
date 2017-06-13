package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entity.Stop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Custom implementation of {@link ScheduleRepository} to efficiently query through all
 * {@link Schedule} entities and get the next departures from the database.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Transactional(readOnly = true)
public class ScheduleRepositoryImpl implements ScheduleRepositoryCustom {

    private final String NATIVE_QUERY = "SELECT * FROM schedule "
            + "LEFT JOIN schedule_update ON schedule.id = schedule_update.schedule "
            + "WHERE schedule.update = ?"
            + "AND stop = ? "
            + "AND planned_departure > ? "
            + "AND journey NOT IN ("
            + "SELECT id FROM journey "
            + "WHERE terminal_station = ?"
            + ")"
            +"AND journey IN ("
            +"SELECT journey FROM calendar_date "
            +"WHERE current_date BETWEEN valid_from AND valid_until"
            +")"
            + "ORDER BY schedule_update.actual_departure, planned_departure "
            + "LIMIT ? OFFSET ?;";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Schedule> findSchedulesByStop(Stop stop, LocalTime time, LocalDateTime timestamp,
                                              Pageable pageable) {
        int pageNumber = pageable.getOffset() - pageable.getPageSize();

        Query query = entityManager.createNativeQuery(NATIVE_QUERY, Schedule.class)
                .setParameter(1, Timestamp.valueOf(timestamp))
                .setParameter(2, stop.getId())
                .setParameter(3, Time.valueOf(time))
                .setParameter(4, stop.getId())
                .setParameter(5, pageable.getPageSize())
                .setParameter(6, pageNumber);
        List<Schedule> result = getResultList(query);

        return new PageImpl<>(result);
    }


    @SuppressWarnings("unchecked")
    private List<Schedule> getResultList(Query query) {
        return query.getResultList();
    }
}
