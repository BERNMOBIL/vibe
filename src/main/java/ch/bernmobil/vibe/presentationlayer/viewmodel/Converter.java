package ch.bernmobil.vibe.presentationlayer.viewmodel;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static ScheduleViewModel convertSchedule(Schedule schedule) {
        ScheduleViewModel viewModel = new ScheduleViewModel();
        viewModel.setPlannedDeparture(schedule.getPlannedDeparture().format(DateTimeFormatter.ofLocalizedTime(
            FormatStyle.SHORT)));
        ScheduleUpdate update = schedule.getScheduleUpdate();
        if (update != null) {
            viewModel.setActualDeparture(update.getActualDeparture().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
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
            .parallelStream()
            .map(Converter::convertSchedule)
            .collect(Collectors.toList());
    }
}
