package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Area;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AreaRepository extends CrudRepository<Area, UUID> {
}
