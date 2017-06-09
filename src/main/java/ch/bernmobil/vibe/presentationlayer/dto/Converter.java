package ch.bernmobil.vibe.presentationlayer.dto;

import static java.time.temporal.ChronoUnit.MINUTES;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Provides converting logic to convert entities into DTOs.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Component
public class Converter {
    private static final ChronoUnit delayUnit = MINUTES;
    @Value("${bernmobil.ruleset.delay}")
    private int timeUntilDelay;

    private final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);

    /**
     * Convert a {@link Schedule} into a {@link ScheduleDto}.
     * @param schedule which should be converted
     * @return A {@link ScheduleDto} which contains necessary information from the {@link Schedule}.
     */
    public ScheduleDto convertSchedule(Schedule schedule) {
        ScheduleDto dto = new ScheduleDto();
        dto.setPlannedDeparture(schedule.getPlannedDeparture().format(dateTimeFormatter));
        ScheduleUpdate update = schedule.getScheduleUpdate();
        if (update != null) {
            long delay = getDelay(schedule.getPlannedDeparture(), schedule.getScheduleUpdate().getActualDeparture());
            dto.setActualDeparture(Long.toString(delay));
            dto.setHasDelay(delay >= timeUntilDelay);
        }
        dto.setLine(schedule.getJourney().getRoute().getLine());
        dto.setDestination(schedule.getJourney().getHeadsign());
        dto.setPlatform(schedule.getPlatform());
        dto.setHasPlatform(!"0".equals(schedule.getPlatform()));
        return dto;
    }

    /**
     * Convert a {@link Stop} into a {@link StopDto}.
     * @param stop which should be converted.
     * @return A {@link StopDto} which contains necessary information from the {@link Stop}.
     */
    public StopDto convertStop(Stop stop) {
        StopDto dto = new StopDto();
        dto.setId(stop.getId());
        dto.setName(stop.getName());
        return dto;
    }

    /**
     * Convert a {@link List} of {@link Schedule} into a {@link List} of {@link ScheduleDto}.
     * @param list of {@link ScheduleDto}
     * @return A {@link List} of {@link ScheduleDto}.
     */
    public List<ScheduleDto> convertScheduleList(List<Schedule> list) {
        return list
                .stream()
                .sorted(Comparator.comparing(Schedule::getPlannedDeparture))
                .map(this::convertSchedule)
                .collect(Collectors.toList());
    }

    /**
     * Calculate the timeUntilDelay of a departure using a {@link ChronoUnit}.
     * @param plannedDeparture from a stop.
     * @param actualDeparture from a stop.
     * @return Numeric value which represents the difference between two {@link LocalTime} using {@link #delayUnit}.
     */
    private long getDelay(LocalTime plannedDeparture, LocalTime actualDeparture) {
        return delayUnit.between(plannedDeparture, actualDeparture);
    }
}
