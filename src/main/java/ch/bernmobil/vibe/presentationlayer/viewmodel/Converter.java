package ch.bernmobil.vibe.presentationlayer.viewmodel;

import static java.time.temporal.ChronoUnit.MINUTES;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Converter {

    private static DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);

    public static ScheduleViewModel convertSchedule(Schedule schedule) {
        ScheduleViewModel viewModel = new ScheduleViewModel();
        viewModel.setPlannedDeparture(schedule.getPlannedDeparture().format(dateTimeFormatter));
        ScheduleUpdate update = schedule.getScheduleUpdate();
        if (update != null) {
            viewModel.setActualDeparture(update.getActualDeparture().format(dateTimeFormatter));
        }
        viewModel.setLine(schedule.getJourney().getRoute().getLine());
        viewModel.setDestination(schedule.getJourney().getHeadsign());
        viewModel.setPlatform(schedule.getPlatform());
        viewModel.setHasPlatform(!schedule.getPlatform().equals("0"));
        return viewModel;
    }

    public static StopViewModel convertStop(Stop stop) {
        StopViewModel viewModel = new StopViewModel();
        viewModel.setId(stop.getId());
        viewModel.setName(stop.getName());
        return viewModel;
    }

    public static List<ScheduleViewModel> convertScheduleList(List<Schedule> list) {
        return list
            .stream()
            .sorted(Comparator.comparing(Schedule::getPlannedDeparture))
            .map(Converter::convertSchedule)
            .collect(Collectors.toList());
    }

    private static String getDelayInMinutes(LocalTime planned, LocalTime actual) {
        long difference = MINUTES.between(planned, actual);
        if(difference == 0) {
            return "OK";
        }
        return Long.toString(difference);
    }
}
