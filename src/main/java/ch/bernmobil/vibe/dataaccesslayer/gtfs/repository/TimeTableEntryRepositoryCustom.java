package ch.bernmobil.vibe.dataaccesslayer.gtfs.repository;


import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.TimeTableEntry;

import java.util.ArrayList;
import java.util.List;


public interface TimeTableEntryRepositoryCustom {
    ArrayList<TimeTableEntry> getTimeTableEntriesByStopName(String stopName, int limit);
}
