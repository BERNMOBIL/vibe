package ch.bernmobil.vibe.gtfs.Repository;

import ch.bernmobil.vibe.gtfs.entity.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Long>{
}
