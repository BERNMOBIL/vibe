package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.shared.entity.hibernate.UpdateHistory;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateHistoryRepository extends CrudRepository<UpdateHistory, UUID> {
    @Query("select max(uh.time) from UpdateHistory uh")
    LocalDateTime findMaxTime();
}
