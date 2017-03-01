package ch.bernmobil.vibe.dataaccesslayer.gtfs.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.StopTime;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


public class StopTimeRepositoryImpl implements StopTimeRepositoryCustom {

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private StopTimeRepository stopTimeRepository;

    /*
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<StopTime> getAllStopTimesFromDepartureToArrival(long departureId, long arrivalId) {
        String queryString = "SELECT * FROM stop_time AS st1 JOIN stop_time AS st2 ON st1.trip_id = st2.trip_id WHERE (st1.stop_stop_id = ? OR st1.stop_stop_id = ?)";


        Query query = entityManager.createNativeQuery(queryString, StopTime.class);
        query.setParameter(1, departureId);
        query.setParameter(2, arrivalId);

        return query.getResultList();
    }*/


    public List<StopTime> getNextDeparturesBy(Stop departureStop) {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        return stopTimeRepository.findAllByStopOrderByDepartureTime(departureStop)
               .stream()
               .filter(stopTime -> stopTime.getDepartureTime().compareTo(now) >= 1
                                   && stopTime.getTrip().getTripHeadsign().compareTo(departureStop.getStopName()) != 0)
               .collect(Collectors.toList());

    }

}
