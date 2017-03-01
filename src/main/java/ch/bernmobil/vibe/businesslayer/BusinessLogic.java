package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.*;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public BusinessLogic(AgencyRepository agencyRepository, StopRepository stopRepository, StopTimeRepository stopTimeRepository, TimeTableEntryRepository timeTableEntryRepository) {
        this.agencyRepository = agencyRepository;
        this.stopRepository = stopRepository;
        this.stopTimeRepository = stopTimeRepository;
        this.timeTableEntryRepository = timeTableEntryRepository;
    }

    public String getName() {
        Agency agency = agencyRepository.findFirstByOrderById();
        return agency.getName();
    }

    public List<StopTime> getNextDeparturesByStopName(String stopName) {
        Stop departureStop = stopRepository.findFirstByStopName(stopName);
        return stopTimeRepository.getNextDeparturesBy(departureStop);
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
