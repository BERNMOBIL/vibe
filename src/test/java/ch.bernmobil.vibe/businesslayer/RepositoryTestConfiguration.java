package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.repository.AgencyRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.repository.StopRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.repository.StopTimeRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("RepositoryTestConfiguration")
@Configuration
public class RepositoryTestConfiguration {
    @Bean
    @Primary
    public StopRepository stopRepository() {
        return Mockito.mock(StopRepository.class);
    }

    @Bean
    @Primary
    public StopTimeRepository stopTimeRepository() {
        return Mockito.mock(StopTimeRepository.class);
    }

    @Bean
    @Primary
    public AgencyRepository agencyRepository() {
        return Mockito.mock(AgencyRepository.class);
    }
}
