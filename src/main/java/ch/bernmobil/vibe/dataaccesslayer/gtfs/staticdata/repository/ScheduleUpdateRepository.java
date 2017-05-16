package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.shared.entity.hibernate.ScheduleUpdate;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ScheduleUpdateRepository extends CrudRepository<ScheduleUpdate, UUID> {

}
