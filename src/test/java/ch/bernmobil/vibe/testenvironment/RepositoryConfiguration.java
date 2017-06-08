package ch.bernmobil.vibe.testenvironment;

import static org.mockito.Mockito.mock;

import ch.bernmobil.vibe.businesslayer.BusinessLogic;
import ch.bernmobil.vibe.dataaccesslayer.repository.AreaRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.CalendarDateRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.CalendarExceptionRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.JourneyRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.RouteRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleUpdateRepository;
import ch.bernmobil.vibe.dataaccesslayer.repository.StopRepository;
import ch.bernmobil.vibe.service.UpdateTimestampService;
import ch.bernmobil.vibe.testenvironment.data.AreaMockData;
import ch.bernmobil.vibe.testenvironment.data.CalendarDateMockData;
import ch.bernmobil.vibe.testenvironment.data.CalendarExceptionMockData;
import ch.bernmobil.vibe.testenvironment.data.JourneyMockData;
import ch.bernmobil.vibe.testenvironment.data.RouteMockData;
import ch.bernmobil.vibe.testenvironment.data.ScheduleMockData;
import ch.bernmobil.vibe.testenvironment.data.ScheduleUpdateMockData;
import ch.bernmobil.vibe.testenvironment.repository.AreaRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.CalendarDateRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.CalendarExceptionRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.JourneyRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.RouteRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.ScheduleRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.ScheduleUpdateRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.StopRepositoryMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("TestConfiguration")
@Configuration
public class RepositoryConfiguration {

    @Bean
    @Primary
    public UpdateTimestampService updateTimestampService() {
        return mock(UpdateTimestampService.class);
    }

    @Bean
    @Primary
    public BusinessLogic businessLogic(ScheduleRepository scheduleRepository,
        ScheduleUpdateRepository scheduleUpdateRepository, StopRepository stopRepository,
        UpdateTimestampService updateTimestampService) {
        return new BusinessLogic(scheduleRepository, scheduleUpdateRepository, stopRepository, updateTimestampService);
    }
    @Bean
    @Primary
    public AreaRepository areaRepository(AreaMockData areaMockData) {
        return new AreaRepositoryMock(areaMockData).getMock();
    }

    @Bean
    @Primary
    public CalendarDateRepository calendarDateRepository(CalendarDateMockData calendarDateMockData) {
        return new CalendarDateRepositoryMock(calendarDateMockData).getMock();
    }

    @Bean
    @Primary
    public CalendarExceptionRepository calendarExceptionRepository(CalendarExceptionMockData calendarExceptionMockData) {
        return new CalendarExceptionRepositoryMock(calendarExceptionMockData).getMock();
    }
    @Bean
    @Primary
    public JourneyRepository journeyRepository(JourneyMockData journeyMockData) {
        return new JourneyRepositoryMock(journeyMockData).getMock();
    }


    @Bean
    @Primary
    public RouteRepository routeRepository(RouteMockData routeMockData) {
        return new RouteRepositoryMock(routeMockData).getMock();
    }

    @Bean
    @Primary
    public ScheduleRepository scheduleRepository(ScheduleMockData scheduleMockData) {
        return new ScheduleRepositoryMock(scheduleMockData).getMock();
    }

    @Bean
    @Primary
    public ScheduleUpdateRepository scheduleUpdateRepository(ScheduleUpdateMockData scheduleUpdateMockData) {
        return new ScheduleUpdateRepositoryMock(scheduleUpdateMockData).getMock();
    }

    @Bean
    @Primary
    public StopRepository stopRepository(StopRepositoryMock stopRepositoryMock) {
        return stopRepositoryMock.getMock();
    }
}
