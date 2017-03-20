package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.businesslayer.mock.StopRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.StopTimeRepositoryMock;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.AgencyRepository;
import ch.bernmobil.vibe.businesslayer.mock.AgencyRepositoryMock;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.StopRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.StopTimeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("RepositoryTestConfiguration")
@Configuration
public class RepositoryTestConfiguration {

    public static StopRepositoryMock stopRepositoryMock;
    public static StopTimeRepositoryMock stopTimeRepositoryMock;
    public static AgencyRepositoryMock agencyRepositoryMock;

    @Bean
    public StopRepository stopRepository() {
        if (stopRepositoryMock == null) {
            stopRepositoryMock = new StopRepositoryMock();
        }

        return stopRepositoryMock.getMock();
    }

    @Bean
    public StopTimeRepository stopTimeRepository() {
        if (stopTimeRepositoryMock == null) {
            stopTimeRepositoryMock = new StopTimeRepositoryMock();
        }

        return stopTimeRepositoryMock.getMock();
    }

    @Bean
    public AgencyRepository agencyRepository() {
        if (agencyRepositoryMock == null) {
            agencyRepositoryMock = new AgencyRepositoryMock();
        }

        return agencyRepositoryMock.getMock();    }

}
