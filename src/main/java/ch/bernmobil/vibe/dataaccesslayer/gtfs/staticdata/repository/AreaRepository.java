package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.shared.entity.hibernate.Area;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface AreaRepository extends CrudRepository<Area, UUID> {

}
