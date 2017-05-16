package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.ScheduleUpdateMockData;
import ch.bernmobil.vibe.shared.entity.hibernate.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.ScheduleUpdateRepository;


public class ScheduleUpdateRepositoryMock extends RepositoryMock<ScheduleUpdate, ScheduleUpdateRepository>{

    public ScheduleUpdateRepositoryMock(){
        super(ScheduleUpdateRepository.class, ScheduleUpdateMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
