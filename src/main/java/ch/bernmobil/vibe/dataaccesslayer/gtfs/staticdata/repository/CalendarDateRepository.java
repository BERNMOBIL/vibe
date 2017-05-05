package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarDate;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CalendarDateRepository extends CrudRepository<CalendarDate, UUID> {
}
