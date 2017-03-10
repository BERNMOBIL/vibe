package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Transfer;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Transfer, Long> {
}
