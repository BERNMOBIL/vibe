package ch.bernmobil.vibe.gtfs.Repository;

import ch.bernmobil.vibe.gtfs.entity.StopTime;
import org.springframework.data.repository.CrudRepository;

public interface StopTimeRepository extends CrudRepository<StopTime, Long> {
}
