package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.*;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.*;


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


    @Autowired
    public BusinessLogic(ScheduleRepository scheduleRepository,
        ScheduleUpdateRepository scheduleUpdateRepository, StopRepository stopRepository) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleUpdateRepository = scheduleUpdateRepository;
        this.stopRepository = stopRepository;
    }

    public List<Stop> findStops(String stopName) {
        return stopRepository.findAllByNameStartingWithIgnoreCase(stopName,
            new Sort(Direction.ASC, "name"));

    }

    public List<Schedule> getNextDeparturesByStopId(long stopId) {
        return getDepartureByStopNameAtTime(stopId, LocalTime.now());
    }

    public List<Schedule> getDepartureByStopNameAtTime(long stopId, LocalTime time) {
        Stop stop = stopRepository.findOne(stopId);
        List<Schedule> allDepartures = scheduleRepository.findAllByStop(stop);


        return allDepartures
            .stream()
            .filter(s -> s.getPlannedDeparture().isAfter(time))
            .sorted(Schedule::compareByDepartureTime)
            .limit(10)
            .collect(Collectors.toList());
    }

}
