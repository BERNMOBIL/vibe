package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.Stop;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Provides access to {@link Stop} entity on the database.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Repository
public interface StopRepository extends CrudRepository<Stop, UUID> {

    /**
     * Find all stops which contain a specified, case insensitive, name.
     * @param name or substring of the name of the searched {@link Stop}
     * @param update timestamp of the current valid version of schedule data.
     * @param sort which contains sorting order (ascending or descending) and a property to sort.
     * @return {@link List} which contains all {@link Stop} substrings from the given name.
     */
    @Query(value = "SELECT s FROM Stop s WHERE s.updateTimestamp = :updateTimestamp AND lower(s.name) LIKE concat('%', lower(:name), '%')")
    List<Stop> findAllByNameWithIgnoreCase(@Param("name") String name, @Param("updateTimestamp") LocalDateTime update, @Param("sort") Sort sort);

    /**
     * Find all {@link Stop} by its name.
     * @param name of the stop.
     * @return {@link List} of {@link Stop}
     */
    List<Stop> findAllByName(String name);
}
