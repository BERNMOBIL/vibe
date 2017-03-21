package ch.bernmobil.vibe.businesslayer;

import ch.bernmobil.vibe.businesslayer.mock.AreaRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.CalendarDateRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.CalendarExceptionRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.JourneyDisruptionRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.JourneyRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.RouteRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.ScheduleRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.ScheduleUpdateRepositoryMock;
import ch.bernmobil.vibe.businesslayer.mock.StopRepositoryMock;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarDate;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.AreaRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.CalendarDateRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.CalendarExceptionRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.JourneyDistruptionRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.JourneyRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.RouteRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.ScheduleRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.ScheduleUpdateRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.StopRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("RepositoryTestConfiguration")
@Configuration
public class RepositoryTestConfiguration {

    public static AreaRepositoryMock areaRepositoryMock;
    public static CalendarDateRepositoryMock calendarDateRepositoryMock;
    public static CalendarExceptionRepositoryMock calendarExceptionRepositoryMock;
    public static JourneyRepositoryMock journeyRepositoryMock;
    public static JourneyDisruptionRepositoryMock journeyDisruptionRepositoryMock;
    public static RouteRepositoryMock routeRepositoryMock;
    public static ScheduleRepositoryMock scheduleRepositoryMock;
    public static ScheduleUpdateRepositoryMock scheduleUpdateRepositoryMock;
    public static StopRepositoryMock stopRepositoryMock;

    @Bean
    @Primary
    public AreaRepository agencyRepository() {
        if (areaRepositoryMock == null) {
            areaRepositoryMock = new AreaRepositoryMock();
        }

        return areaRepositoryMock.getMock();
    }

    @Bean
    @Primary
    public CalendarDateRepository calendarDateRepository() {
        if (calendarDateRepositoryMock == null) {
            calendarDateRepositoryMock = new CalendarDateRepositoryMock();
        }

        return calendarDateRepositoryMock.getMock();
    }

    @Bean
    @Primary
    public CalendarExceptionRepository calendarExceptionRepository() {
        if (calendarExceptionRepositoryMock == null) {
            calendarExceptionRepositoryMock = new CalendarExceptionRepositoryMock();
        }

        return calendarExceptionRepositoryMock.getMock();
    }
    @Bean
    @Primary
    public JourneyRepository journeyRepository() {
        if (journeyRepositoryMock == null) {
            journeyRepositoryMock = new JourneyRepositoryMock();
        }

        return journeyRepositoryMock.getMock();
    }

    @Bean
    @Primary
    public JourneyDistruptionRepository journeyDistruptionRepository() {
        if (journeyDisruptionRepositoryMock == null) {
            journeyDisruptionRepositoryMock = new JourneyDisruptionRepositoryMock();
        }

        return journeyDisruptionRepositoryMock.getMock();
    }

    @Bean
    @Primary
    public RouteRepository routeRepository() {
        if (routeRepositoryMock == null) {
            routeRepositoryMock = new RouteRepositoryMock();
        }

        return routeRepositoryMock.getMock();
    }

    @Bean
    @Primary
    public ScheduleRepository scheduleRepository() {
        if (scheduleRepositoryMock == null) {
            scheduleRepositoryMock = new ScheduleRepositoryMock();
        }

        return scheduleRepositoryMock.getMock();
    }

    @Bean
    @Primary
    public ScheduleUpdateRepository scheduleUpdateRepository() {
        if (scheduleUpdateRepositoryMock == null) {
            scheduleUpdateRepositoryMock = new ScheduleUpdateRepositoryMock();
        }

        return scheduleUpdateRepositoryMock.getMock();
    }

    @Bean
    @Primary
    public StopRepository stopRepository() {
        if (stopRepositoryMock == null) {
            stopRepositoryMock = new StopRepositoryMock();
        }

        return stopRepositoryMock.getMock();
    }
}
