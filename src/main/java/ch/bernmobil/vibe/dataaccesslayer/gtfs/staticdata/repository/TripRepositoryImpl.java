package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Trip;
import com.google.transit.realtime.GtfsRealtime;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


public class TripRepositoryImpl implements TripRepositoryCustom {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Trip getTripFromTripUpdate(GtfsRealtime.TripUpdate tripUpdate) {
        String[] tripIdParts = tripUpdate.getTrip().getTripId().split("_");
        String firstRandomNumber = tripIdParts[0];
        String secondRandomNumber = tripIdParts[1];
        String thirdRandomNumber = tripIdParts[2];
        String departureStopIdUnformatted = tripIdParts[3];
        String arrivalStopIdUnformatted = tripIdParts[4];
        String departureTimeUnformatted = tripIdParts[5];
        String arrivalTimeUnformatted = tripIdParts[6];


        while(departureStopIdUnformatted.length() < 5) {
            departureStopIdUnformatted = "0" + departureStopIdUnformatted;
        }
        departureStopIdUnformatted = "85" + departureStopIdUnformatted;

        while(arrivalStopIdUnformatted.length() < 5) {
            arrivalStopIdUnformatted = "0" + arrivalStopIdUnformatted;
        }
        arrivalStopIdUnformatted = "85" + arrivalStopIdUnformatted;

        String queryString = "SELECT DISTINCT ON(trip.id) * FROM trip " +
                "JOIN stop_time AS s1 ON s1.trip_id = trip.id " +
                "JOIN stop_time AS s2 ON s2.trip_id = trip.id " +
                "WHERE " +
                "(s1.stop_stop_id = ? AND s1.departure_time LIKE ?) " +
                "OR " +
                "(s1.stop_stop_id = ? AND s1.departure_time LIKE ?)";


        Query query = entityManager.createNativeQuery(queryString, Trip.class);
        query.setParameter(1, Integer.parseInt(departureStopIdUnformatted));
        query.setParameter(2, departureTimeUnformatted + '%');
        query.setParameter(3, Integer.parseInt(arrivalStopIdUnformatted));
        query.setParameter(4, arrivalStopIdUnformatted +'%');

        Trip trip = (Trip) query.getResultList().get(0);

        return trip;
    }

}
