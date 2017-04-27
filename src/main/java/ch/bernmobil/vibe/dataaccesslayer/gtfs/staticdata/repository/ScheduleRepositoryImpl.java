package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class ScheduleRepositoryImpl implements ScheduleRepositoryCustom {
    private final static String queryString = "SELECT * FROM schedule "
        + "WHERE stop = ? "
        + "AND planned_departure > ? "
        + "ORDER BY planned_departure "
        + "LIMIT ? OFFSET ?;";

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Page<Schedule> findSchedulesByStop(Stop stop, LocalTime time, Pageable pageable) {
        //TODO order
        int pageNumber = pageable.getOffset() - pageable.getPageSize();
        Query query = entityManager.createNativeQuery(queryString, Schedule.class)
            .setParameter(1, stop.getId())
            .setParameter(2, Time.valueOf(time))
            .setParameter(3, pageable.getPageSize())
            .setParameter(4, pageNumber);
        List<Schedule> result = query.getResultList();
        return new PageImpl<>(result);
    }
}
