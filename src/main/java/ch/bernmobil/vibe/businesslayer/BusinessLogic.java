package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.entity.Agency;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessLogic implements IBusinessLogic {

    @Autowired
    private final AgencyRepository agencyRepository;

    public BusinessLogic(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public String getName() {
        Agency agency = agencyRepository.findFirstByOrderById();
        return agency.getName();
    }
}
