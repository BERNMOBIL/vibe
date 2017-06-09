package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entity.Stop;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Custom implementation of {@link ScheduleRepository} to efficiently query through all
 * {@link Schedule} entities and get the next departures from the database.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Transactional(readOnly = true)
public class ScheduleRepositoryImpl implements ScheduleRepositoryCustom {

    private final String HQL_QUERY = "select s from Schedule s " +
        "left join s.scheduleUpdate as su " +
        "where s.updateTimestamp = :lastUpdate " +
        "and s.stop = :stop " +
        "and s.plannedDeparture > :time " +
        "and s.journey not in ( " +
        "  select j from Journey j " +
        "  where j.terminalStation = :terminalStation " +
        ") " +
        "and s.journey in (" +
        "  select c.journey from CalendarDate c " +
        "  where current_date between c.validFrom and c.validUntil) " +
        "order by su.actualDeparture, s.plannedDeparture";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Schedule> findSchedulesByStop(Stop stop, LocalTime time, LocalDateTime timestamp,
        Pageable pageable) {
        Query query = entityManager.createQuery(HQL_QUERY, Schedule.class);
        query.setParameter("lastUpdate", timestamp)
            .setParameter("stop", stop)
            .setParameter("time", time)
            .setParameter("terminalStation", stop)
            .setMaxResults(pageable.getPageSize());

        List<Schedule> list = getResultList(query);
        return new PageImpl<>(list);
    }


    @SuppressWarnings("unchecked")
    private List<Schedule> getResultList(Query query) {
        return query.getResultList();
    }
}
