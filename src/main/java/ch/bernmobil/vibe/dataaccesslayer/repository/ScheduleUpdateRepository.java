package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ScheduleUpdateRepository extends CrudRepository<ScheduleUpdate, UUID> {
    Collection<ScheduleUpdate> findAll();
}
