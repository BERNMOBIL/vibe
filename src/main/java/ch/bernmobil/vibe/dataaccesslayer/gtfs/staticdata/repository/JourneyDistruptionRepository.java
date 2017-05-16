package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.shared.entity.hibernate.JourneyDisruption;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface JourneyDistruptionRepository extends CrudRepository<JourneyDisruption, UUID> {
}
