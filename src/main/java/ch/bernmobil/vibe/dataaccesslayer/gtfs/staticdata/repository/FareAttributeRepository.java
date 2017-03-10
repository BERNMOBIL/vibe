package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.FareAttribute;
import org.springframework.data.repository.CrudRepository;

public interface FareAttributeRepository extends CrudRepository<FareAttribute, Long> {
}
