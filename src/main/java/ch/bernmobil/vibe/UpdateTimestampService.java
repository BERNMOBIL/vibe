package ch.bernmobil.vibe;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.UpdateHistoryRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class UpdateTimestampService {
    private final Logger logger = Logger.getLogger(UpdateTimestampService.class);
    private final UpdateHistoryRepository updateHistoryRepository;
    private LocalDateTime currentTimestamp;

    @Autowired
    public UpdateTimestampService(UpdateHistoryRepository updateHistoryRepository) {
        this.updateHistoryRepository = updateHistoryRepository;
    }

    @Scheduled(fixedRate = 60 * 1000)
    public void checkTimestamp() {
        logger.info("Polling update-timestamp");
        check().thenAccept(update ->  {
            currentTimestamp = update;
            logger.info(String.format("Update-timestamp set to %s", currentTimestamp));
        }).exceptionally(throwable -> {
            logger.error(String.format("Error reading timestamp: "), throwable);
            //TODO: this seems odd
            return null;
        });
    }

    private CompletableFuture<LocalDateTime> check() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<LocalDateTime> maxTimestamp = Optional.ofNullable(updateHistoryRepository.findMaxTime());
            return maxTimestamp.orElse(LocalDateTime.now());
        });
    }

    public LocalDateTime getCurrentTimestamp() {
        return currentTimestamp;
    }
}
