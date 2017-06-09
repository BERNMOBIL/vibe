package ch.bernmobil.vibe.testenvironment.repository;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.dataaccesslayer.entity.Journey;
import ch.bernmobil.vibe.dataaccesslayer.repository.JourneyRepository;
import ch.bernmobil.vibe.testenvironment.data.JourneyMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JourneyRepositoryMock extends RepositoryMock<Journey, JourneyRepository>{

    @Autowired
    public JourneyRepositoryMock(JourneyMockData journeyMockData){
        super(JourneyRepository.class, journeyMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
