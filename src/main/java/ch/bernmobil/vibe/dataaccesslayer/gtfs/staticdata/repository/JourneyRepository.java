package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.shared.entity.hibernate.Journey;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface JourneyRepository extends CrudRepository<Journey, UUID> {
}
