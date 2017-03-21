package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarException;
import org.springframework.data.repository.CrudRepository;

public interface CalendarExceptionRepository extends CrudRepository<CalendarException, Long> {
}
