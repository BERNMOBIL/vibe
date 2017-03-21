package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarDate;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.JourneyDistruption;
import org.springframework.data.repository.CrudRepository;

public interface JourneyDistruptionRepository extends CrudRepository<JourneyDistruption, Long> {
}
