package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Agency;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.StopTime;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Trip;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BusinessLogic {

    @Autowired
    private final AgencyRepository agencyRepository;

    @Autowired
    private final RouteRepository routeRepository;

    @Autowired
    private final StopRepository stopRepository;

    @Autowired
    private final StopTimeRepository stopTimeRepository;

    public BusinessLogic(AgencyRepository agencyRepository, RouteRepository routeRepository, StopRepository stopRepository, StopTimeRepository stopTimeRepository) {
        this.agencyRepository = agencyRepository;
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
        this.stopTimeRepository = stopTimeRepository;
    }

    public String getName() {
        Agency agency = agencyRepository.findFirstByOrderById();
        return agency.getName();
    }

    public ArrayList<StopTime> getNextTripsByStopName(String stopName) {
        Stop stop = stopRepository.findFirstByStopName(stopName);
        StopTime stopTime = stopTimeRepository.findFirstByStop(stop);
        Trip trip = stopTime.getTrip();
        ArrayList<StopTime> allStopTimes = stopTimeRepository.findAllByTrip(trip);

        return allStopTimes;
    }

    public ArrayList<StopTime> getAllStopTimesByStopName(String stopName) {
        Stop startStop = stopRepository.findFirstByStopName(stopName);
        return stopTimeRepository.findAllByStop(startStop);
    }

    public ArrayList<StopTime> getAllTripsByDestinationStop() {
        String start = "Rapperswil";
        String destination = "Zürich HB";

        ArrayList<StopTime> allStartingStopTimes = getAllStopTimesByStopName(start);
        ArrayList<StopTime> allDestinationStopTimes = getAllStopTimesByStopName(destination);

        ArrayList<Trip> allStartingTrips = new ArrayList<>();
        for(StopTime stopTime : allStartingStopTimes) allStartingTrips.add(stopTime.getTrip());

        ArrayList<Trip> allDestinationTrips = new ArrayList<>();
        for(StopTime stopTime : allDestinationStopTimes) allDestinationTrips.add(stopTime.getTrip());

        ArrayList<StopTime> resultingStopTimes = new ArrayList<>();

        for(StopTime startStopTime : allStartingStopTimes) {
            StopTime destinationStopTime = findByTrip(allDestinationStopTimes, startStopTime.getTrip());
            if(startStopTime != null && destinationStopTime != null && startStopTime.getStopSequence() < destinationStopTime.getStopSequence()){
                resultingStopTimes.add(startStopTime);
            }
        }

        return resultingStopTimes;
    }

    private StopTime findByTrip(ArrayList<StopTime> list, Trip trip) {
        for(StopTime stopTime : list) {
            if(stopTime.getTrip().equals(trip)) return stopTime;
        }
        return null;
    }
}
