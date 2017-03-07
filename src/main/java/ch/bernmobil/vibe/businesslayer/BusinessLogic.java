package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.realtimedata.repository.TripUpdateRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.*;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.*;
import com.google.transit.realtime.GtfsRealtime.TripUpdate.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BusinessLogic {

    private final AgencyRepository agencyRepository;
    private final StopRepository stopRepository;
    private final StopTimeRepository stopTimeRepository;
    private final TripUpdateRepository tripUpdateRepository;
    private final TripRepository tripRepository;
    private final RealtimeUpdateLogic realtimeUpdateLogic;

    @Autowired
    public BusinessLogic(AgencyRepository agencyRepository, StopRepository stopRepository, StopTimeRepository stopTimeRepository, TripUpdateRepository tripUpdateRepository, TripRepository tripRepository, RealtimeUpdateLogic realtimeUpdateLogic) {
        this.agencyRepository = agencyRepository;
        this.stopRepository = stopRepository;
        this.stopTimeRepository = stopTimeRepository;
        this.tripUpdateRepository = tripUpdateRepository;
        this.tripRepository = tripRepository;
        this.realtimeUpdateLogic = realtimeUpdateLogic;
    }

    public String getName() {
        Agency agency = agencyRepository.findFirstByOrderById();
        return agency.getName();
    }


    public List<StopTime> getNextDeparturesByStopName(String stopName) {
        Stop departureStop = stopRepository.findFirstByStopName(stopName);
        List<StopTime> nextDepartures = stopTimeRepository.getNextDeparturesBy(departureStop);

        HashMap<Trip, HashMap<StopTime, StopTimeUpdate>> allUpdates = realtimeUpdateLogic.getAllUpdates();


        return nextDepartures;
    }

}
