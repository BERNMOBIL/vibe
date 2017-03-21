package ch.bernmobil.vibe.dataaccesslayer.gtfs.realtimedata.repository;

import com.google.transit.realtime.GtfsRealtime;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TripUpdateRepository extends GTFSRealtimeRepository {


    public TripUpdateRepository() throws IOException { }

    public List<GtfsRealtime.FeedEntity> getTripUpdates() {
        return  getFeedEntities()
                .stream()
                .filter(GtfsRealtime.FeedEntity::hasTripUpdate)
                .collect(Collectors.toList());
    }
}
