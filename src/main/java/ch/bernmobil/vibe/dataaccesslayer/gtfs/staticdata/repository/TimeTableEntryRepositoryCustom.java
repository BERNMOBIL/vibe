package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;


import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.TimeTableEntry;

import java.util.ArrayList;


public interface TimeTableEntryRepositoryCustom {
    ArrayList<TimeTableEntry> getTimeTableEntriesByStopName(String stopName, int limit);
}
