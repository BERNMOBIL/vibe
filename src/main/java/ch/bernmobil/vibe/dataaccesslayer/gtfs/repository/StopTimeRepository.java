package ch.bernmobil.vibe.dataaccesslayer.gtfs.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.StopTime;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface StopTimeRepository extends CrudRepository<StopTime, String> {
    StopTime findFirstByStop(Stop stop);
    ArrayList<StopTime> findAllByTrip(Trip trip);
    ArrayList<StopTime> findAllByStop(Stop stop);
}
