package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.Area;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface AreaRepository extends CrudRepository<Area, UUID> {

}
