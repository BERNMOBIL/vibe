package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.data.repository.query.Param;

public interface StopRepository extends CrudRepository<Stop, Long> {
    //@Query("select s from Stop s where s.name like CONCAT(:stopName, '%')")
    Page<Stop> findAllByNameStartingWithIgnoreCase(@Param("stopName") String stopName, Pageable pageable);
    Stop findFirstByName(String name);
}
