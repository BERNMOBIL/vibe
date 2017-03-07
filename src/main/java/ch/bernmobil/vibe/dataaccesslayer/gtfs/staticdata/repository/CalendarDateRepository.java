package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarDate;
import org.springframework.data.repository.CrudRepository;

public interface CalendarDateRepository extends CrudRepository<CalendarDate, Long> {
}
