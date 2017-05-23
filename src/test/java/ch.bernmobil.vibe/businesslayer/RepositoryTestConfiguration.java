package ch.bernmobil.vibe.businesslayer;

import static org.mockito.Mockito.mock;

import ch.bernmobil.vibe.service.UpdateTimestampService;
import ch.bernmobil.vibe.businesslayer.mock.AreaRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.CalendarDateRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.CalendarExceptionRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.JourneyDisruptionRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.JourneyRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.RouteRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.ScheduleRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.ScheduleUpdateRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.StopRepositoryMock;
import ch.bernmobil.vibe.dataaccesslayer.repository.AreaRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.CalendarDateRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.CalendarExceptionRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.JourneyDistruptionRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.JourneyRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.RouteRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleUpdateRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Profile("RepositoryTestConfiguration")
@Configuration
public class RepositoryTestConfiguration {

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public UpdateTimestampService updateTimestampService() {
        return mock(UpdateTimestampService.class);
    }
    @Bean
    @Primary
    @Autowired
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public BusinessLogic businessLogic(ScheduleRepository scheduleRepository,
        ScheduleUpdateRepository scheduleUpdateRepository, StopRepository stopRepository,
        UpdateTimestampService updateTimestampService) {
        return new BusinessLogic(scheduleRepository, scheduleUpdateRepository, stopRepository, updateTimestampService);
    }
    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public AreaRepository agencyRepository() {
        return new AreaRepositoryMock().getMock();
    }

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CalendarDateRepository calendarDateRepository() {
        return new CalendarDateRepositoryMock().getMock();
    }

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CalendarExceptionRepository calendarExceptionRepository() {
        return new CalendarExceptionRepositoryMock().getMock();
    }
    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public JourneyRepository journeyRepository() {
        return new JourneyRepositoryMock().getMock();
    }

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public JourneyDistruptionRepository journeyDistruptionRepository() {
        return new JourneyDisruptionRepositoryMock().getMock();
    }

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public RouteRepository routeRepository() {
        return new RouteRepositoryMock().getMock();
    }

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ScheduleRepository scheduleRepository() {
        return new ScheduleRepositoryMock().getMock();
    }

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ScheduleUpdateRepository scheduleUpdateRepository() {
        return new ScheduleUpdateRepositoryMock().getMock();
    }

    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public StopRepository stopRepository() {
        return new StopRepositoryMock().getMock();
    }
}
