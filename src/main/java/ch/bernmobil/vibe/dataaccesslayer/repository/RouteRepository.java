package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entity.Route;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<Route, UUID> {
}
