package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.UpdateHistory;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateHistoryRepository extends CrudRepository<UpdateHistory, UUID> {
    @Query("select max(a.time) from UpdateHistory a")
    LocalDateTime findMaxTime();
}
