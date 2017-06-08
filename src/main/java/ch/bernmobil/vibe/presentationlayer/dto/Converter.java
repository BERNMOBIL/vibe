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

@Component
public class Converter {
    @Value("${bernmobil.ruleset.delay}")
    private int delay;
    private final ChronoUnit unit = MINUTES;

    private static DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);

    public ScheduleDto convertSchedule(Schedule schedule) {
        ScheduleDto viewModel = new ScheduleDto();
        viewModel.setPlannedDeparture(schedule.getPlannedDeparture().format(dateTimeFormatter));
        ScheduleUpdate update = schedule.getScheduleUpdate();
        if (update != null) {
            long delay = getDelay(schedule.getPlannedDeparture(), schedule.getScheduleUpdate().getActualDeparture());
            viewModel.setActualDeparture(Long.toString(delay));
            viewModel.setHasDelay(delay > 0);
        }
        viewModel.setLine(schedule.getJourney().getRoute().getLine());
        viewModel.setDestination(schedule.getJourney().getHeadsign());
        viewModel.setPlatform(schedule.getPlatform());
        viewModel.setHasPlatform(!schedule.getPlatform().equals("0"));
        return viewModel;
    }

    public StopDto convertStop(Stop stop) {
        StopDto viewModel = new StopDto();
        viewModel.setId(stop.getId());
        viewModel.setName(stop.getName());
        return viewModel;
    }

    public List<ScheduleDto> convertScheduleList(List<Schedule> list) {
        return list
                .stream()
                .sorted(Comparator.comparing(Schedule::getPlannedDeparture))
                .map(this::convertSchedule)
                .collect(Collectors.toList());
    }

    private long getDelay(LocalTime plannedDeparture, LocalTime actualDeparture) {
        return unit.between(plannedDeparture, actualDeparture);
    }
}
