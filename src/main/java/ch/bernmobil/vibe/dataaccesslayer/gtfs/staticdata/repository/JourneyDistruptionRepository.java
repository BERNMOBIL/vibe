package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.JourneyDisruption;
import org.springframework.data.repository.CrudRepository;

public interface JourneyDistruptionRepository extends CrudRepository<JourneyDisruption, Long> {
}
