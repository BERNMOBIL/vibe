package ch.bernmobil.vibe.dataaccesslayer.gtfs.realtimedata.repository;

import com.google.protobuf.TextFormat;
import com.google.transit.realtime.GtfsRealtime;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GTFSRealtimeRepository {

    //TODO: default url?
    private final String defaultAPIUrl = "http://localhost:9000/api?filename=realtime.pb";

    private List<GtfsRealtime.FeedEntity> feedEntities;
    private GtfsRealtime.FeedMessage feedMessage;

    public GTFSRealtimeRepository() {
        loadEntities(defaultAPIUrl);
    }

    private void loadEntities(String url) {
        try {
            //TODO Handle Exception
            InputStreamReader reader = new InputStreamReader(new URL(url).openStream(), "UTF-8");
            GtfsRealtime.FeedMessage.Builder builder = GtfsRealtime.FeedMessage.newBuilder();
            TextFormat.merge(reader, builder);

            feedMessage = builder.build();
            feedEntities = feedMessage.getEntityList();

        } catch (IOException e) {}
    }


    protected final List<GtfsRealtime.FeedEntity> getFeedEntities() {
        if(feedEntities == null) {
            loadEntities(defaultAPIUrl);
        }
        return feedEntities;
    }

    public final GtfsRealtime.FeedMessage getFeedMessage() {
        if(feedMessage == null) {
            loadEntities(defaultAPIUrl);
        }
        return feedMessage;
    }


}
