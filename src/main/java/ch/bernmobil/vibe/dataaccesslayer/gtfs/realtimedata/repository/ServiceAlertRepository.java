package ch.bernmobil.vibe.dataaccesslayer.gtfs.realtimedata.repository;

import com.google.transit.realtime.GtfsRealtime;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceAlertRepository extends GTFSRealtimeRepository {


    public ServiceAlertRepository() throws IOException {

    }

    public List<GtfsRealtime.FeedEntity> getServiceAlerts() throws IOException {
        return  getFeedEntities()
                .stream()
                .filter(GtfsRealtime.FeedEntity::hasAlert)
                .collect(Collectors.toList());

    }
}
