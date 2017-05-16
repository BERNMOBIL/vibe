package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.shared.entity.hibernate.Schedule;
import ch.bernmobil.vibe.shared.entity.hibernate.Stop;

import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepositoryCustom {
    Page<Schedule> findSchedulesByStop(Stop stop, LocalTime time, LocalDateTime timestamp, Pageable pageable);
}
