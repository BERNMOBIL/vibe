package ch.bernmobil.vibe.testenvironment.repository;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.dataaccesslayer.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.repository.StopRepository;
import ch.bernmobil.vibe.testenvironment.data.StopMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StopRepositoryMock extends RepositoryMock<Stop, StopRepository>{

    @Autowired
    public StopRepositoryMock(StopMockData stopMockData) {
        super(StopRepository.class, stopMockData.getDataSource());
    }

    protected void configureMock() {
      when(mock.findAll()).thenReturn(dataSource);
    }
}
