package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.StopRepository;
import ch.bernmobil.vibe.service.UpdateTimestampService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

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

    public List<Schedule> getDeparturesByStopId(UUID stopId, LocalTime time, int size) {
        Stop stop = stopRepository.findOne(stopId);
        Page<Schedule> page = scheduleRepository.findSchedulesByStop(
            stop,
            time,
            updateTimestampService.getCurrentTimestamp(),
            new PageRequest(1, size, Direction.ASC, "plannedDeparture"));
        List<Schedule> result = page.getContent();
        return result;
    }

    public Stop getNewestStopEntity(Stop stop) {
        List<Stop> allStops = stopRepository.findAllByName(stop.getName());

        Optional<Stop> newStopOptional = allStops
                .stream()
                .filter(s -> s.getUpdateTimestamp().equals(updateTimestampService.getCurrentTimestamp()))
                .findFirst();

        return newStopOptional.orElse(stop);
    }

}
