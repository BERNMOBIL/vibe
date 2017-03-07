package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface StopTimeRepository extends CrudRepository<StopTime, String>, StopTimeRepositoryCustom {
    StopTime findFirstByStop(Stop stop);
    ArrayList<StopTime> findAllByTrip(Trip trip);
    List<StopTime> findAllByStopOrderByDepartureTime(Stop stop);
    StopTime findFirstByTripAndStop(Trip trip, Stop stop);


}
