package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface StopRepository extends CrudRepository<Stop, UUID> {
    @Query(value = "SELECT s FROM Stop s WHERE s.lastUpdate = :updateTimestamp AND s.name LIKE :name")
    List<Stop> findAllByNameWithIgnoreCase(@Param("name") String name, @Param("updateTimestamp") LocalDateTime update, @Param("sort") Sort sort);
}
