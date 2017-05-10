package ch.bernmobil.vibe;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.AreaRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
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
    private final AreaRepository areaRepository;
    private LocalDateTime currentTimestamp;

    @Autowired
    public UpdateTimestampService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
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
            List<LocalDateTime> timestamps = areaRepository.findDistinctUpdateTimestamp();
            logger.debug(String.format("Found timestamps: %s", timestamps));
            Optional<LocalDateTime> t = timestamps.stream().max(Comparator.naturalOrder());
            logger.debug(String.format("Newest timestamp: %s", t));
            return t.orElse(LocalDateTime.now());
        });
    }

    public LocalDateTime getCurrentTimestamp() {
        return currentTimestamp;
    }
}
