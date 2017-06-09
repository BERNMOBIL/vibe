package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.CalendarException;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CalendarExceptionRepository extends CrudRepository<CalendarException, UUID> {
}
