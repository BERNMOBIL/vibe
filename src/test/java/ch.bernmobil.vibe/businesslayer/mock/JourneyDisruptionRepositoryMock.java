package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.JourneyDisruptionMockData;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.JourneyDistruption;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.JourneyDistruptionRepository;


public class JourneyDisruptionRepositoryMock extends RepositoryMock<JourneyDistruption, JourneyDistruptionRepository>{

    public JourneyDisruptionRepositoryMock(){
        super(JourneyDistruptionRepository.class, JourneyDisruptionMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
