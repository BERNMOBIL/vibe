package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.AreaMockData;
import ch.bernmobil.vibe.businesslayer.mock.data.JourneyMockData;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Area;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Journey;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.AreaRepository;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.JourneyRepository;


public class JourneyRepositoryMock extends RepositoryMock<Journey, JourneyRepository>{

    public JourneyRepositoryMock(){
        super(JourneyRepository.class, JourneyMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
