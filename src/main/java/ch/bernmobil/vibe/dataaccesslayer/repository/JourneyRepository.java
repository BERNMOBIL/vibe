package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Journey;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface JourneyRepository extends CrudRepository<Journey, UUID> {
}
