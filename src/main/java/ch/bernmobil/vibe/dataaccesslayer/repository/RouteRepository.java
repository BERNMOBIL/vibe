package ch.bernmobil.vibe.dataaccesslayer.repository;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RouteRepository extends CrudRepository<Route, UUID> {
}
