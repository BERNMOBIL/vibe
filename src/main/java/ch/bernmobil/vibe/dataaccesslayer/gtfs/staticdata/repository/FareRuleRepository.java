package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.FareRule;
import org.springframework.data.repository.CrudRepository;

public interface FareRuleRepository extends CrudRepository<FareRule, Long> {
}
