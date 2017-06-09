package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.Journey;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface JourneyRepository extends CrudRepository<Journey, UUID> {
}
