package ch.bernmobil.vibe.service;

import ch.bernmobil.vibe.dataaccesslayer.repository.UpdateHistoryRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class UpdateTimestampService implements Observer {
    private final Logger logger = Logger.getLogger(UpdateTimestampService.class);
    private final UpdateHistoryRepository updateHistoryRepository;
    private LocalDateTime currentTimestamp;

    @Autowired
    public UpdateTimestampService(UpdateHistoryRepository updateHistoryRepository, UpdateNotificationReceiver receiver) {
        this.updateHistoryRepository = updateHistoryRepository;
        receiver.addObserver(this);
        checkTimestamp();
    }

    public void checkTimestamp() {
        logger.info("Polling update-timestamp");
        check().thenAccept(this::updateTimestamp).exceptionally(this::futureExceptionHandler);
    }

    private CompletableFuture<LocalDateTime> check() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<LocalDateTime> maxTimestamp = Optional.ofNullable(updateHistoryRepository.findMaxTime());
            return maxTimestamp
                .orElseThrow(() -> new DataRetrievalFailureException("Could not retrieve a matching row in update history table"));
        });
    }

    private Void futureExceptionHandler(Throwable throwable) {
        logger.error("Error reading timestamp: ", throwable);
        return null;
    }

    private void updateTimestamp(LocalDateTime update) {
        currentTimestamp = update;
        logger.info(String.format("Update-timestamp set to %s", currentTimestamp));
    }
    public LocalDateTime getCurrentTimestamp() {
        return currentTimestamp;
    }

    @Override
    public void update(Observable o, Object arg) {
        checkTimestamp();
    }
}
