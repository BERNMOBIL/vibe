package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.CalendarDate;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CalendarDateRepository extends CrudRepository<CalendarDate, UUID> {
}
