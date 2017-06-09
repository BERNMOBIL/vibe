package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleUpdateRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.StopRepository;
import ch.bernmobil.vibe.service.UpdateTimestampService;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * Provides logic components for the presentation layer, to access to data from data-access layer.
 * Its purpose is to take off as much load from the presentation layer.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Service
public class BusinessLogic {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleUpdateRepository scheduleUpdateRepository;
    private final StopRepository stopRepository;
    private final UpdateTimestampService updateTimestampService;

    @Autowired
    public BusinessLogic(ScheduleRepository scheduleRepository,
        ScheduleUpdateRepository scheduleUpdateRepository,
        StopRepository stopRepository,
        UpdateTimestampService updateTimestampService) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleUpdateRepository = scheduleUpdateRepository;
        this.stopRepository = stopRepository;
        this.updateTimestampService = updateTimestampService;
    }

    /**
     * Find all {@link Stop} beginning with a given name.
     * @param stopName which is searched.
     * @return {@link List} of {@link Stop} which are beginning with the searched name.
     */
    public List<Stop> findStops(String stopName) {
        LocalDateTime timestamp = updateTimestampService.getCurrentTimestamp();
        return stopRepository.
                findAllByNameWithIgnoreCase(stopName,
                    timestamp, new Sort(Direction.ASC, "name"));
    }

    /**
     * Get a stop by its id.
     * @param id of the {@link Stop}
     * @return The {@link Stop} with the id, if none was found it returns null.
     */
    public Stop getStopById(UUID id) {
        return stopRepository.findOne(id);
    }

    /**
     * Find all departures from a {@link Stop} after a specified time.
     * @param stopId of the {@link Stop} to which the {@link Schedule} will be searched.
     * @param time which is compared, and all {@link Schedule} with a {@link Schedule#plannedDeparture}
     * after this time will be returned.
     * @param size The number of {@link Schedule} which will be in the resulting {@link List}.
     * @return {@link List} of {@link Schedule} of the defined size.
     */
    public List<Schedule> getDeparturesByStopId(UUID stopId, LocalTime time, int size) {
        Stop stop = stopRepository.findOne(stopId);
        Page<Schedule> page = scheduleRepository.findSchedulesByStop(
            stop,
            time,
            updateTimestampService.getCurrentTimestamp(),
            new PageRequest(1, size, Direction.ASC, "plannedDeparture"));
        return page.getContent();
    }

    /**
     * Check if there is a newer version of a {@link Stop} by its {@link Stop#name}. It searches all
     * {@link Stop} which have the same name as the given {@link Stop} and returns the {@link Stop}
     * which has the latest successful timestamp, as saved in {@link UpdateTimestampService}.
     * @param stop of which a possible newer version is available.
     * @return A newer {@link Stop} if any, or the given {@link Stop} if there is no newer version,
     * or null if there is no {@link Stop} with the given name.
     */
    public Stop getNewestStopVersion(Stop stop) {
        List<Stop> allStops = stopRepository.findAllByName(stop.getName());

        Optional<Stop> newStopOptional = allStops
                .stream()
                .filter(s -> s.getUpdateTimestamp().equals(updateTimestampService.getCurrentTimestamp()))
                .findFirst();

        return newStopOptional.orElse(null);
    }

    /**
     * Get the next 100 {@link ScheduleUpdate}.
     * @return {@link Collection} of the next 100 {@link ScheduleUpdate}
     */
    public Collection<ScheduleUpdate> getNextScheduleUpdates() {
        Page<ScheduleUpdate> page = scheduleUpdateRepository.findAll(new PageRequest(1, 100));
        return page.getContent();
    }

}
