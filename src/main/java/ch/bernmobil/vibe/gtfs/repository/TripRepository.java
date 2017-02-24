package ch.bernmobil.vibe.gtfs.repository;

import ch.bernmobil.vibe.gtfs.entity.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {
}
