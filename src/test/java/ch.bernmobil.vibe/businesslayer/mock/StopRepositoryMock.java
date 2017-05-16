package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.StopMockData;
import ch.bernmobil.vibe.shared.entity.hibernate.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.StopRepository;

public class StopRepositoryMock extends RepositoryMock<Stop, StopRepository>{

    public StopRepositoryMock() {
        super(StopRepository.class, StopMockData.getDataSource());
    }

    protected void configureMock() {
      when(mock.findAll()).thenReturn(dataSource);
    }
}
