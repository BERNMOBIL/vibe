package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Shape;
import org.springframework.data.repository.CrudRepository;

public interface ShapeRepository extends CrudRepository<Shape, Long> {
}
