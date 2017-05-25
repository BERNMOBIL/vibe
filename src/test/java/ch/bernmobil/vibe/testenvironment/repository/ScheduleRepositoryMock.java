package ch.bernmobil.vibe.testenvironment.repository;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.dataaccesslayer.repository.ScheduleRepository;
import ch.bernmobil.vibe.testenvironment.data.ScheduleMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleRepositoryMock extends RepositoryMock<Schedule, ScheduleRepository>{

    @Autowired
    public ScheduleRepositoryMock(ScheduleMockData scheduleMockData){
        super(ScheduleRepository.class, scheduleMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
        when(mock.findAllByStop(any(Stop.class))).thenReturn(dataSource.subList(0,2));
    }


}
