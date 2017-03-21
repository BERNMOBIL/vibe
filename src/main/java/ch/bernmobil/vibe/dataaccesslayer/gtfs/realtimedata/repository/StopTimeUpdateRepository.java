package ch.bernmobil.vibe.dataaccesslayer.gtfs.realtimedata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.realtimedata.entity.StopTimeUpdateEntity;
import org.springframework.data.repository.CrudRepository;

public interface StopTimeUpdateRepository extends CrudRepository<StopTimeUpdateEntity, String> {
    StopTimeUpdateEntity findByStopId(long id);
}
