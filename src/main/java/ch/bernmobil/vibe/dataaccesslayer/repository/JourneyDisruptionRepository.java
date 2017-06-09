package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.JourneyDisruption;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface JourneyDisruptionRepository extends CrudRepository<JourneyDisruption, UUID> {
}
