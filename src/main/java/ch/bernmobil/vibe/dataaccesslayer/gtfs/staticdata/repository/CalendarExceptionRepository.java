package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.shared.entity.hibernate.CalendarException;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CalendarExceptionRepository extends CrudRepository<CalendarException, UUID> {
}
