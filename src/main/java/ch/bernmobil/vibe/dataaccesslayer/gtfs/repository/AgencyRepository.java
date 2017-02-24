package ch.bernmobil.vibe.dataaccesslayer.gtfs.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Agency;
import org.springframework.data.repository.CrudRepository;


public interface AgencyRepository extends CrudRepository<Agency, Long> {
    Agency findFirstByOrderById();
}
