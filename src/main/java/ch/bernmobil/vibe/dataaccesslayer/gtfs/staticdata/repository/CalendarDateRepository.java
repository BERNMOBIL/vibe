package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.shared.entity.hibernate.CalendarDate;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CalendarDateRepository extends CrudRepository<CalendarDate, UUID> {
}
