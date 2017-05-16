package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.shared.entity.hibernate.Schedule;
import ch.bernmobil.vibe.shared.entity.hibernate.Stop;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, UUID>, ScheduleRepositoryCustom {
    List<Schedule> findAllByStop(Stop stop);
    List<Schedule> findAll();
}
