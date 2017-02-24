package ch.bernmobil.vibe.gtfs.Repository;

import ch.bernmobil.vibe.gtfs.entity.CalendarDate;
import org.springframework.data.repository.CrudRepository;

public interface CalendarDateRepository extends CrudRepository<CalendarDate, Long> {
}
