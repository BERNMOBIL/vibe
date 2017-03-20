package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.*;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessLogic {

    private final AgencyRepository agencyRepository;
    private final StopRepository stopRepository;
    private final StopTimeRepository stopTimeRepository;


    @Autowired
    public BusinessLogic(AgencyRepository agencyRepository, StopRepository stopRepository,
        StopTimeRepository stopTimeRepository) {
        this.agencyRepository = agencyRepository;
        this.stopRepository = stopRepository;
        this.stopTimeRepository = stopTimeRepository;
    }

    public String getAgencyName() {
        Agency agency = agencyRepository.findFirstByOrderById();
        return agency.getName();
    }


    public List<StopTime> getNextDeparturesByStopName(String stopName) {

        Stop departureStop = stopRepository.findFirstByStopName(stopName);
        List<StopTime> nextDepartures = stopTimeRepository.getNextDeparturesBy(departureStop);


        return nextDepartures;
    }

}
