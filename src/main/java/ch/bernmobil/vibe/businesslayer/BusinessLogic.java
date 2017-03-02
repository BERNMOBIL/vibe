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

    private final AgencyRepository agencyRepository;

    private final StopRepository stopRepository;

    private final StopTimeRepository stopTimeRepository;

    @Autowired
    public BusinessLogic(AgencyRepository agencyRepository, StopRepository stopRepository, StopTimeRepository stopTimeRepository) {
        this.agencyRepository = agencyRepository;
        this.stopRepository = stopRepository;
        this.stopTimeRepository = stopTimeRepository;
    }

    public String getName() {
        Agency agency = agencyRepository.findFirstByOrderById();
        return agency.getName();
    }

    public List<StopTime> getNextDeparturesByStopName(String stopName) {
        Stop departureStop = stopRepository.findFirstByStopName(stopName);
        return stopTimeRepository.getNextDeparturesBy(departureStop);
    }

}
