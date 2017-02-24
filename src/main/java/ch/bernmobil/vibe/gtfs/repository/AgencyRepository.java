package ch.bernmobil.vibe.gtfs.repository;

import ch.bernmobil.vibe.gtfs.entity.Agency;
import org.springframework.data.repository.CrudRepository;


public interface AgencyRepository extends CrudRepository<Agency, Long> {
}
