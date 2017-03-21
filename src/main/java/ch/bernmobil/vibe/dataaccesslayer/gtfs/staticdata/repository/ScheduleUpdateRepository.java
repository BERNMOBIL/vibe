package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.ScheduleUpdate;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleUpdateRepository extends CrudRepository<ScheduleUpdate, Long> {
}
