package ch.bernmobil.vibe.dataaccesslayer.gtfs.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.StopTime;
import org.springframework.data.repository.CrudRepository;

public interface StopTimeRepository extends CrudRepository<StopTime, String> {
}
