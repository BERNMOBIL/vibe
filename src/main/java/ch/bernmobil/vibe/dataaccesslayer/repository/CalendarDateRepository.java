package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.CalendarDate;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CalendarDateRepository extends CrudRepository<CalendarDate, UUID> {
}
