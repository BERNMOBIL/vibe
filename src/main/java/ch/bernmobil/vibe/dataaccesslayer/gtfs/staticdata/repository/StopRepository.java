package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.query.Param;

public interface StopRepository extends CrudRepository<Stop, UUID>, StopRepositoryCustom {
    List<Stop> findAllByUpdateAndNameStartingWithIgnoreCase(Timestamp update, String name, Sort sort);
    List<Stop> findAllByName(String name);

    List<Stop> findAllByNameStartingWithIgnoreCase(Timestamp update, String name, Sort sort);
}
