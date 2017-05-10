package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Area;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AreaRepository extends CrudRepository<Area, UUID> {
    @Query("select distinct a.updateTimestamp from Area a")
    List<LocalDateTime> findDistinctUpdateTimestamp();
}
