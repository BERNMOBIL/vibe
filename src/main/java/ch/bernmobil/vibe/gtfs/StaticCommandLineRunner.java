package ch.bernmobil.vibe.gtfs;

import ch.bernmobil.vibe.gtfs.entity.Agency;
import ch.bernmobil.vibe.gtfs.repository.AgencyRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StaticCommandLineRunner implements CommandLineRunner {
    @Autowired
    private AgencyRepository agencyRepository;
    private Logger logger = Logger.getLogger(getClass());
    @Override
    public void run(String... args) throws Exception {
        Iterable<Agency> it = agencyRepository.findAll();
        for(Agency a: it){
            logger.info(a.getName());
        }
    }
}
