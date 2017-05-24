package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.JourneyMockData;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Journey;
import ch.bernmobil.vibe.dataaccesslayer.repository.JourneyRepository;


public class JourneyRepositoryMock extends RepositoryMock<Journey, JourneyRepository>{

    public JourneyRepositoryMock(){
        super(JourneyRepository.class, JourneyMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
