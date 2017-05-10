package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.UpdateTimestampService;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.*;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.*;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;
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
    private final StopRepository stopRepository;
    private final UpdateTimestampService updateTimestampService;

    @Autowired
    public BusinessLogic(ScheduleRepository scheduleRepository,
        StopRepository stopRepository,
        UpdateTimestampService updateTimestampService) {
        this.scheduleRepository = scheduleRepository;
        this.stopRepository = stopRepository;
        this.updateTimestampService = updateTimestampService;
    }

    public List<Stop> findStops(String stopName) {
        LocalDateTime timestamp = updateTimestampService.getCurrentTimestamp();
        //TODO: manually append % should be avoided
        return stopRepository.
                findAllByNameWithIgnoreCase(stopName + "%",
                    timestamp, new Sort(Direction.ASC, "name"));
    }

    public Stop getStopById(UUID id) {
        return stopRepository.findOne(id);
    }

    public List<Schedule> getNextDeparturesByStopId(UUID stopId) {
        return getDepartureByStopIdAtTime(stopId, LocalTime.now());
    }

    public List<Schedule> getDepartureByStopIdAtTime(UUID stopId, LocalTime time) {
        Stop stop = stopRepository.findOne(stopId);
        List<Schedule> allDepartures = scheduleRepository.findAllByStop(stop);

        return allDepartures
            .stream()
            .filter(s -> s.getPlannedDeparture().isAfter(time))
            .sorted(Schedule::compareByDepartureTime)
            .limit(10)
            .collect(Collectors.toList());
    }

    public List<Schedule> getDeparturesByStopId(UUID stopId, LocalTime time) {
        Stop stop = stopRepository.findOne(stopId);
        Page<Schedule> page = scheduleRepository.findSchedulesByStop(
            stop,
            time,
                updateTimestampService.getCurrentTimestamp(),
            new PageRequest(1, 10, Direction.ASC, "plannedDeparture"));
        return page.getContent();

    }

}
