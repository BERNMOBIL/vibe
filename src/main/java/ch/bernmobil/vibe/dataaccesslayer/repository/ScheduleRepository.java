package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entity.Stop;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides access to {@link Schedule} entities in the database.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, UUID>, ScheduleRepositoryCustom {

    /**
     * Find all {@link Schedule} by its {@link Stop}.
     * @param stop to which the {@link Schedule} are searched
     * @return {@link List} of {@link Schedule}.
     */
    List<Schedule> findAllByStop(Stop stop);
}
