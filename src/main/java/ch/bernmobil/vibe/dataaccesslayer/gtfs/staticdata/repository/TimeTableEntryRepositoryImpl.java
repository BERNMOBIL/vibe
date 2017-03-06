package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.TimeTableEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;


public class TimeTableEntryRepositoryImpl implements TimeTableEntryRepositoryCustom {

    @Autowired
    private TimeTableEntryRepository timeTableEntryRepository;

    @Autowired
    private StopRepository stopRepository;

    public ArrayList<TimeTableEntry> getTimeTableEntriesByStopName(String stopName, int limit) {
        PageRequest pageRequest = new PageRequest(0, limit);
        Stop stop = stopRepository.findFirstByStopName(stopName);

        return timeTableEntryRepository.findDistinctByDepartureStop(stop, pageRequest);
    }

}
