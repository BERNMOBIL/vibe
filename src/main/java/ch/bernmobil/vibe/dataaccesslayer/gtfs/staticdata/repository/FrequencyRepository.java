package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Frequency;
import org.springframework.data.repository.CrudRepository;

public interface FrequencyRepository extends CrudRepository<Frequency, Long> {
}
