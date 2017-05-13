package ch.bernmobil.vibe.service;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.UpdateHistoryRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
public class UpdateTimestampService {
    private final Logger logger = Logger.getLogger(UpdateTimestampService.class);
    private final UpdateHistoryRepository updateHistoryRepository;
    private LocalDateTime currentTimestamp;

    @Autowired
    public UpdateTimestampService(UpdateHistoryRepository updateHistoryRepository) {
        this.updateHistoryRepository = updateHistoryRepository;
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

}
