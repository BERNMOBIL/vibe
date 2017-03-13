package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.realtimedata.repository.TripUpdateRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Trip;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.StopRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.StopTimeRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.TripRepositoryCustom;
import com.google.transit.realtime.GtfsRealtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RealtimeUpdateLogic {

    private final TripUpdateRepository tripUpdateRepository;
    private final TripRepositoryCustom tripRepository;
    private final StopRepository stopRepository;
    private final StopTimeRepository stopTimeRepository;

    @Autowired
    public RealtimeUpdateLogic(TripUpdateRepository tripUpdateRepository, TripRepositoryCustom tripRepository, StopRepository stopRepository, StopTimeRepository stopTimeRepository) {
        this.tripUpdateRepository = tripUpdateRepository;
        this.tripRepository = tripRepository;
        this.stopRepository = stopRepository;
        this.stopTimeRepository = stopTimeRepository;
    }

    public HashMap<Trip, HashMap<StopTime, GtfsRealtime.TripUpdate.StopTimeUpdate>> getAllUpdates() {
        List<GtfsRealtime.FeedEntity> tripUpdates = tripUpdateRepository.getTripUpdates();


        HashMap<Trip, HashMap<StopTime, GtfsRealtime.TripUpdate.StopTimeUpdate>> allTripUpdates = new HashMap<>();

        for(GtfsRealtime.FeedEntity feedEntity : tripUpdates) {
            GtfsRealtime.TripUpdate tripUpdate = feedEntity.getTripUpdate();
            Trip trip = tripRepository.getTripFromTripUpdate(tripUpdate);

            HashMap<StopTime, GtfsRealtime.TripUpdate.StopTimeUpdate> allStopTimesUpdates = getStopTimeUpdatesByTripUpdate(tripUpdate, trip);
            allTripUpdates.put(trip, allStopTimesUpdates);
        }

        return allTripUpdates;
    }

    private HashMap<StopTime, GtfsRealtime.TripUpdate.StopTimeUpdate> getStopTimeUpdatesByTripUpdate(GtfsRealtime.TripUpdate tripUpdate, Trip trip) {
        HashMap<StopTime, GtfsRealtime.TripUpdate.StopTimeUpdate> allStopTimesUpdates = new HashMap<>();

        for(GtfsRealtime.TripUpdate.StopTimeUpdate stopTimeUpdate : tripUpdate.getStopTimeUpdateList())
        {
            Stop stop = stopRepository.findFirstByStopId(getValidStopId(stopTimeUpdate.getStopId()));
            StopTime stopTime = stopTimeRepository.findFirstByTripAndStop(trip, stop);

            allStopTimesUpdates.put(stopTime, stopTimeUpdate);
        }

        return allStopTimesUpdates;
    }

    private long getValidStopId(String unformattedStopId) {
        unformattedStopId = unformattedStopId.split("_")[0];
        while(unformattedStopId.length() < 5) unformattedStopId = "0" + unformattedStopId;
        return Long.parseLong("85" + unformattedStopId);
    }
}
