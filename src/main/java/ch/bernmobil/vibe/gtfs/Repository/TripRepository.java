package ch.bernmobil.vibe.gtfs.Repository;

import ch.bernmobil.vibe.gtfs.entity.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {
}
