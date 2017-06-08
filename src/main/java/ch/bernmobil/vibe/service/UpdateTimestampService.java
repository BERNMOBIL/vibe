package ch.bernmobil.vibe.service;

import ch.bernmobil.vibe.dataaccesslayer.repository.UpdateHistoryRepository;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTimestampService implements Observer {
    private final Logger logger = Logger.getLogger(UpdateTimestampService.class);
    private final UpdateHistoryRepository updateHistoryRepository;
    private LocalDateTime currentTimestamp;

    @Autowired
    public UpdateTimestampService(UpdateHistoryRepository updateHistoryRepository, UpdateNotificationReceiver receiver) {
        this.updateHistoryRepository = updateHistoryRepository;
        receiver.addObserver(this);
        setUpdateTimestampIfPresent();
    }

    /**
     * Looks through the update_history table and searches for the latest timestamp which has status
     * successful. Since JPA 2.1 does not directly support new the Java 1.8  Date and Time API
     * , including {@link LocalDateTime}, there is no possibility to convert a field with an
     * {@link javax.persistence.Id}.
     *
     * @see javax.persistence.Id
     */
    public void setUpdateTimestampIfPresent() {
        logger.info("Polling update-timestamp");
        LocalDateTime timestamp = updateHistoryRepository.findLatestSuccessTimestamp().toLocalDateTime();
        if(timestamp == null) {
            logger.error("No timestamp found with status: SUCCESS");
        } else {
            logger.info(String.format("Update-timestamp set to %s", timestamp));
            currentTimestamp = timestamp;
        }

    }

    public LocalDateTime getCurrentTimestamp() {
        return currentTimestamp;
    }

    @Override
    public void update(Observable o, Object arg) {
        setUpdateTimestampIfPresent();
    }
}
