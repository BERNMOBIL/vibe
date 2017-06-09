package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.ScheduleUpdate;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleUpdateRepository extends CrudRepository<ScheduleUpdate, UUID> {
    Page<ScheduleUpdate> findAll(Pageable pageable);
}
