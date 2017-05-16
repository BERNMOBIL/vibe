package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.JourneyDisruption;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface JourneyDistruptionRepository extends CrudRepository<JourneyDisruption, UUID> {
}
