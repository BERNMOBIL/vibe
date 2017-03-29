package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.data.repository.query.Param;

public interface StopRepository extends CrudRepository<Stop, Long> {
    List<Stop> findAllByNameStartingWithIgnoreCase(@Param("stopName") String stopName, Sort sort);
    Stop findFirstByName(String name);
}
