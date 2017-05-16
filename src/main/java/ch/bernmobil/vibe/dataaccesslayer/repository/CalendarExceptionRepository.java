package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.CalendarException;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CalendarExceptionRepository extends CrudRepository<CalendarException, UUID> {
}
