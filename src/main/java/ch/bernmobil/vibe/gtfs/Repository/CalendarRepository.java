package ch.bernmobil.vibe.gtfs.Repository;

import ch.bernmobil.vibe.gtfs.entity.Calendar;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<Calendar, Long> {
}
