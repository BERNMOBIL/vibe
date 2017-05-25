package ch.bernmobil.vibe.testenvironment.repository;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleUpdateRepository;
import ch.bernmobil.vibe.testenvironment.data.ScheduleUpdateMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleUpdateRepositoryMock extends RepositoryMock<ScheduleUpdate, ScheduleUpdateRepository>{

    @Autowired
    public ScheduleUpdateRepositoryMock(ScheduleUpdateMockData scheduleUpdateMockData){
        super(ScheduleUpdateRepository.class, scheduleUpdateMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
