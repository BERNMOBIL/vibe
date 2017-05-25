package ch.bernmobil.vibe.testenvironment.repository;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Area;
import ch.bernmobil.vibe.dataaccesslayer.repository.AreaRepository;
import ch.bernmobil.vibe.testenvironment.data.AreaMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AreaRepositoryMock extends RepositoryMock<Area, AreaRepository>{

    @Autowired
    public AreaRepositoryMock(AreaMockData areaMockData){
        super(AreaRepository.class, areaMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
