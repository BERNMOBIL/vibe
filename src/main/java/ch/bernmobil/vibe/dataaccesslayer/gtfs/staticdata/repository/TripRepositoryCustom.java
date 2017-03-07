package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Trip;
import com.google.transit.realtime.GtfsRealtime;

public interface TripRepositoryCustom {
    Trip getTripFromTripUpdate(GtfsRealtime.TripUpdate tripUpdate);
}
