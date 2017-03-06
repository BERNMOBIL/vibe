package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.realtimedata.repository.TripUpdateRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.*;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.*;
import com.google.transit.realtime.GtfsRealtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessLogic {

    @Autowired
    private final AgencyRepository agencyRepository;

    @Autowired
    private final StopRepository stopRepository;

    @Autowired
    private final StopTimeRepository stopTimeRepository;

    @Autowired
    private final TimeTableEntryRepository timeTableEntryRepository;

    @Autowired
    private final TripUpdateRepository tripUpdateRepository;


    public BusinessLogic(AgencyRepository agencyRepository, StopRepository stopRepository, StopTimeRepository stopTimeRepository, TimeTableEntryRepository timeTableEntryRepository, TripUpdateRepository tripUpdateRepository) {
        this.agencyRepository = agencyRepository;
        this.stopRepository = stopRepository;
        this.stopTimeRepository = stopTimeRepository;
        this.timeTableEntryRepository = timeTableEntryRepository;
        this.tripUpdateRepository = tripUpdateRepository;
    }

    public String getName() {
        Agency agency = agencyRepository.findFirstByOrderById();
        return agency.getName();
    }

    public List<StopTime> getNextDeparturesByStopName(String stopName) {
        Stop departureStop = stopRepository.findFirstByStopName(stopName);
        List<StopTime> nextDepartures = stopTimeRepository.getNextDeparturesBy(departureStop);

        List<GtfsRealtime.FeedEntity> tripUpdates = tripUpdateRepository.getTripUpdates();

        //TODO: Merge Updates with static data;


        return nextDepartures;
    }


    public ArrayList<StopTime> getAllStopTimesFromArrivalToDestination (String departureStopName, String arrivalStopName) {

        Stop departureStop = stopRepository.findFirstByStopName(departureStopName);
        Stop arrivalStop = stopRepository.findFirstByStopName(arrivalStopName);


        List<StopTime> allDepartingStopTimes = stopTimeRepository.findAllByStopOrderByDepartureTime(departureStop);
        List<StopTime> allArrivalStopTimes = stopTimeRepository.findAllByStopOrderByDepartureTime(arrivalStop);

        ArrayList<StopTime> filteredDepartureStopTimes = new ArrayList<>();

        //TODO: Make this better
        for(StopTime departureStopTime : allDepartingStopTimes) {
            for(StopTime arrivalStopTime : allArrivalStopTimes) {
                if(departureStopTime.getTrip().getId() == arrivalStopTime.getTrip().getId() && departureStopTime.getStopSequence() < arrivalStopTime.getStopSequence()){
                    filteredDepartureStopTimes.add(departureStopTime);
                }
            }
        }


        return filteredDepartureStopTimes;
    }

    public ArrayList<TimeTableEntry> getTimeTableEntriesByStopName(String departureStopName) {
        return timeTableEntryRepository.getTimeTableEntriesByStopName("Rüti ZH", 10);
    }


}
