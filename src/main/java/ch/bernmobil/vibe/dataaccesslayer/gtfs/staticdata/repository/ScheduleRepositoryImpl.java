package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class ScheduleRepositoryImpl implements ScheduleRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Page<Schedule> findSchedulesByStop(Stop stop, LocalTime time, Pageable pageable) {
        //TODO order
        int pageNumber = pageable.getOffset() - pageable.getPageSize();
        Query query = entityManager.createNativeQuery("SELECT * FROM schedule WHERE stop = :stopId AND planned_departure > :time ORDER BY planned_departure LIMIT :pageLimit OFFSET :pageOffset", Schedule.class)
            .setParameter("stopId", stop.getId())
            .setParameter("time", Time.valueOf(time))
            .setParameter("pageLimit", pageable.getPageSize())
            .setParameter("pageOffset", pageNumber);
        List<Schedule> result = query.getResultList();
        return new PageImpl<>(result);
    }
}
