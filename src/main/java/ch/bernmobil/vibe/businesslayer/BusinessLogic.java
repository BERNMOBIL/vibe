package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.*;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.*;


import java.time.LocalTime;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessLogic {

    private final ScheduleRepository scheduleRepository;
    private final StopRepository stopRepository;


    @Autowired
    public BusinessLogic(ScheduleRepository scheduleRepository, StopRepository stopRepository) {
        this.scheduleRepository = scheduleRepository;
        this.stopRepository = stopRepository;
    }


    public List<Schedule> getNextDeparturesByStopName(String stopName) {
        Stop stop = stopRepository.findFirstByName(stopName);
        List<Schedule> allDepartures = scheduleRepository.findAllByStop(stop);

        List<Schedule> nextDepartures = allDepartures
            .stream()
            .filter(s -> s.getPlanned_departure().isAfter(LocalTime.now()))
            .sorted((s1, s2) -> s1.getPlanned_departure().isBefore(s2.getPlanned_departure()) ? -1 : 1)
            .limit(10)
            .collect(Collectors.toList());

        return nextDepartures;
    }

}
