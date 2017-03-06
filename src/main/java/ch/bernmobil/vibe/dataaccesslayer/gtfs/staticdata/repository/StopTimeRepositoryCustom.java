package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime;
import java.util.List;


public interface StopTimeRepositoryCustom {
    List<StopTime> getNextDeparturesBy(Stop departureStop);
}
