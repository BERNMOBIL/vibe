package ch.bernmobil.vibe.gtfs.repository;

import ch.bernmobil.vibe.gtfs.entity.CalendarDate;
import org.springframework.data.repository.CrudRepository;

public interface CalendarDateRepository extends CrudRepository<CalendarDate, Long> {
}
