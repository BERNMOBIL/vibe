package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarException;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CalendarExceptionRepository extends CrudRepository<CalendarException, UUID> {
}
