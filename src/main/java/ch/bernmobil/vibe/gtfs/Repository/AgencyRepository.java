package ch.bernmobil.vibe.gtfs.Repository;

import ch.bernmobil.vibe.gtfs.entity.Agency;
import org.springframework.data.repository.CrudRepository;


public interface AgencyRepository extends CrudRepository<Agency, Long> {
}
