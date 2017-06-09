package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.UpdateHistory;
import java.sql.Timestamp;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provides access to {@link UpdateHistory} entity on the database.
 *
 * @author Oliviero Chiodo
 * @author Matteo Patisso
 */
@Repository
public interface UpdateHistoryRepository extends CrudRepository<UpdateHistory, UUID> {

    /**
     * Search the latest successful timestamp in the update history table.
     * @return Newest {@link Timestamp} which has status "success".
     */
    @Query("select max(uh.time) from UpdateHistory uh where uh.status = 'SUCCESS'")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    Timestamp findLatestSuccessTimestamp();
}
