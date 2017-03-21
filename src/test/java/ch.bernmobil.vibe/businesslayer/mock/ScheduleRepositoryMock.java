package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.ScheduleMockData;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.ScheduleRepository;


public class ScheduleRepositoryMock extends RepositoryMock<Schedule, ScheduleRepository>{

    public ScheduleRepositoryMock(){
        super(ScheduleRepository.class, ScheduleMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
        when(mock.findAllByStop(any(Stop.class))).thenReturn(dataSource.subList(0,2));
    }


}
