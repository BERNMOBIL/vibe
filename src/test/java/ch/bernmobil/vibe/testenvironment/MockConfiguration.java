package ch.bernmobil.vibe.testenvironment;

import ch.bernmobil.vibe.testenvironment.data.ScheduleMockData;
import ch.bernmobil.vibe.testenvironment.data.ScheduleUpdateMockData;
import ch.bernmobil.vibe.testenvironment.data.StopMockData;
import ch.bernmobil.vibe.testenvironment.repository.ScheduleRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.ScheduleUpdateRepositoryMock;
import ch.bernmobil.vibe.testenvironment.repository.StopRepositoryMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockConfiguration {
    @Bean
    public StopRepositoryMock stopRepositoryMock(StopMockData stopMockData) {
        return new StopRepositoryMock(stopMockData);
    }

    @Bean
    public ScheduleRepositoryMock scheduleRepositoryMock(ScheduleMockData scheduleMockData) {
        return new ScheduleRepositoryMock(scheduleMockData);
    }

    @Bean
    public ScheduleUpdateRepositoryMock scheduleUpdateRepositoryMock(ScheduleUpdateMockData scheduleUpdateMockData) {
        return new ScheduleUpdateRepositoryMock(scheduleUpdateMockData);
    }
}
