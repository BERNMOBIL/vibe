package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Transactional(readOnly = true)
public class ScheduleRepositoryImpl implements ScheduleRepositoryCustom {
    private final static String queryString = "SELECT * FROM schedule "
            + "WHERE schedule.update = ?"
            + "AND stop = ? "
            + "AND planned_departure > ? "
            + "ORDER BY planned_departure "
            + "LIMIT ? OFFSET ?;";

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Page<Schedule> findSchedulesByStop(Stop stop, LocalTime time, LocalDateTime timestamp, Pageable pageable) {
        //TODO order
        int pageNumber = pageable.getOffset() - pageable.getPageSize();
        Query query = entityManager.createNativeQuery(queryString, Schedule.class)
                .setParameter(1, Timestamp.valueOf(timestamp))
                .setParameter(2, stop.getId())
                .setParameter(3, Time.valueOf(time))
                .setParameter(4, pageable.getPageSize())
                .setParameter(5, pageNumber);
        List<Schedule> result = query.getResultList();
        return new PageImpl<>(result);
    }
}
