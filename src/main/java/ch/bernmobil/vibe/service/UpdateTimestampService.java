package ch.bernmobil.vibe.service;

import ch.bernmobil.vibe.dataaccesslayer.repository.UpdateHistoryRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

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

    public void setUpdateTimestampIfPresent() {
        logger.info("Polling update-timestamp");
        LocalDateTime timestamp = updateHistoryRepository.findLatestSuccessTimestamp();
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
