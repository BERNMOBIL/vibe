package ch.bernmobil.vibe.testenvironment;

import ch.bernmobil.vibe.testenvironment.data.AreaMockData;
import ch.bernmobil.vibe.testenvironment.data.CalendarDateMockData;
import ch.bernmobil.vibe.testenvironment.data.CalendarExceptionMockData;
import ch.bernmobil.vibe.testenvironment.data.JourneyMockData;
import ch.bernmobil.vibe.testenvironment.data.RouteMockData;
import ch.bernmobil.vibe.testenvironment.data.ScheduleMockData;
import ch.bernmobil.vibe.testenvironment.data.ScheduleUpdateMockData;
import ch.bernmobil.vibe.testenvironment.data.StopMockData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("TestConfiguration")
@Configuration
public class MockDataConfiguration {

    @Bean
    public AreaMockData areaMockData() {
        return new AreaMockData();
    }

    @Bean
    public CalendarDateMockData calendarDateMockData(JourneyMockData journeyMockData) {
        return new CalendarDateMockData(journeyMockData);
    }

    @Bean
    public StopMockData stopMockData(AreaMockData areaMockData) {
        return new StopMockData(areaMockData);
    }

    @Bean
    public JourneyMockData journeyMockData(RouteMockData routeMockData) {
        return new JourneyMockData(routeMockData);
    }

    @Bean
    public RouteMockData routeMockData() {
        return new RouteMockData();
    }

    @Bean
    public CalendarExceptionMockData calendarExceptionMockData(CalendarDateMockData calendarDateMockData){
        return new CalendarExceptionMockData(calendarDateMockData);
    }

    @Bean
    public ScheduleMockData scheduleMockData(StopMockData stopMockData, JourneyMockData journeyMockData) {
        return new ScheduleMockData(stopMockData, journeyMockData);
    }

    @Bean
    public ScheduleUpdateMockData scheduleUpdateMockData(ScheduleMockData scheduleMockData) {
        return new ScheduleUpdateMockData(scheduleMockData);
    }
}
