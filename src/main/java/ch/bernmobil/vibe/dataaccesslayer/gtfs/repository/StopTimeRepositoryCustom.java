package ch.bernmobil.vibe.dataaccesslayer.gtfs.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.StopTime;
import java.util.List;


public interface StopTimeRepositoryCustom {
    List<StopTime> getNextDeparturesBy(Stop departureStop);
}
