package ch.bernmobil.vibe.dataaccesslayer.gtfs.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.StopTime;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TripRepository extends CrudRepository<Trip, String> {

}
