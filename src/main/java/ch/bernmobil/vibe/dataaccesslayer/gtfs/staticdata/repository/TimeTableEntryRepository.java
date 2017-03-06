package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.TimeTableEntry;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TimeTableEntryRepository extends CrudRepository<TimeTableEntry, Long>, TimeTableEntryRepositoryCustom{
    ArrayList<TimeTableEntry> findDistinctByDepartureStop(Stop departureStop, Pageable pageable);

}
