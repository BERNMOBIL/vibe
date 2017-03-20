package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.StopMockData;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.StopRepository;

public class StopRepositoryMock extends RepositoryMock<Stop, StopRepository>{

    public StopRepositoryMock() {
        super(StopRepository.class);
    }

    @Override
    protected Stop getMockObject(int index) {
        return StopMockData.create(index);
    }

    protected void configureMock() {
      when(mock.findAll()).thenReturn(dataSource);
      when(mock.findFirstByStopName(anyString())).thenReturn(dataSource.get(0));
      when(mock.findFirstByStopId(anyLong())).thenReturn(dataSource.get(0));
  }
}
