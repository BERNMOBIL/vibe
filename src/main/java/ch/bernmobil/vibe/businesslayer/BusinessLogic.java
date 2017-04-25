package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.*;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.*;


import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessLogic {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleUpdateRepository scheduleUpdateRepository;
    private final StopRepository stopRepository;
    private static final Timestamp UPDATE_TIME = Timestamp.valueOf("2017-04-25 09:30:08.094");


    @Autowired
    public BusinessLogic(ScheduleRepository scheduleRepository,
        ScheduleUpdateRepository scheduleUpdateRepository, StopRepository stopRepository) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleUpdateRepository = scheduleUpdateRepository;
        this.stopRepository = stopRepository;
    }

    public List<Stop> findStops(String stopName) {

        return stopRepository.findAllByUpdateAndName(UPDATE_TIME, "Gümligen");

//        return stopRepository.findAllByNameStartingWithIgnoreCase(
//            stopName,
//            new Sort(Direction.ASC, "name")
//        );

    }

    public Stop getStopById(long id) {
        return stopRepository.findOne(id);
    }

    public List<Schedule> getNextDeparturesByStopId(long stopId) {
        return getDepartureByStopNameAtTimeSlow(stopId, LocalTime.now());
    }

    public List<Schedule> getDepartureByStopNameAtTimeSlow(long stopId, LocalTime time) {
        Stop stop = stopRepository.findOne(stopId);
        List<Schedule> allDepartures = scheduleRepository.findAllByStop(stop);

        return allDepartures
            .stream()
            .filter(s -> s.getPlannedDeparture().isAfter(time))
            .sorted(Schedule::compareByDepartureTime)
            .limit(10)
            .collect(Collectors.toList());
    }

    public List<Schedule> getDeparturesByStopId(long stopId, LocalTime time) {
        Stop stop = stopRepository.findOne(stopId);
        Page<Schedule> page = scheduleRepository.findSchedulesByStop(
            stop,
            time,
            new PageRequest(1, 10, Direction.ASC, "plannedDeparture"));
        return page.getContent();

    }

}
