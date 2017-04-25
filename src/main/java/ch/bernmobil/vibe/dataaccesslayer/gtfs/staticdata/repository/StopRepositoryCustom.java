package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StopRepositoryCustom {
    List<Stop> findAllByUpdateAndName(Timestamp update, String name);
}
