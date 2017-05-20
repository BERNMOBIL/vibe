package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.UpdateHistory;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UpdateHistoryRepository extends CrudRepository<UpdateHistory, UUID> {
    @Query("select max(uh.time) from UpdateHistory uh")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    LocalDateTime findMaxTime();
}
