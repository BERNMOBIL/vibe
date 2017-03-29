package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.*;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.*;


import java.sql.Time;
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

    public List<Schedule> getDeparturesByStopId(long stopId, LocalTime time) {
        Stop stop = stopRepository.findOne(stopId);
        Page<Schedule> page = scheduleRepository.findSchedulesByStop(
            stop,
            time,
            new PageRequest(1, 10, Direction.ASC, "plannedDeparture"));
        return page.getContent();

    }

}
