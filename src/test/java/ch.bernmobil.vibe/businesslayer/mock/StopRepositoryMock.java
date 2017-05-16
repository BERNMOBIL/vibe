package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.StopMockData;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import ch.bernmobil.vibe.dataaccesslayer.repository.StopRepository;

public class StopRepositoryMock extends RepositoryMock<Stop, StopRepository>{

    public StopRepositoryMock() {
        super(StopRepository.class, StopMockData.getDataSource());
    }

    protected void configureMock() {
      when(mock.findAll()).thenReturn(dataSource);
    }
}
