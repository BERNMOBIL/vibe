package ch.bernmobil.vibe.gtfs.repository;

import ch.bernmobil.vibe.gtfs.entity.Calendar;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<Calendar, Long> {
}
