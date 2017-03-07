package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


public class StopTimeRepositoryImpl implements StopTimeRepositoryCustom {

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private StopTimeRepository stopTimeRepository;

    public List<StopTime> getNextDeparturesBy(Stop departureStop) {
        LocalTime now = LocalTime.now();//.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        return stopTimeRepository
                .findAllByStopOrderByDepartureTime(departureStop)
               .stream()
               .filter(stopTime -> stopTime
                       .getDepartureTime().compareTo(now) >= 1 &&
                       stopTime
                               .getTrip()
                               .getTripHeadsign()
                               .compareTo(departureStop.getStopName()) != 0
               )
               .collect(Collectors.toList());

    }
}
