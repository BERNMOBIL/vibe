package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.AreaMockData;
import ch.bernmobil.vibe.shared.entity.hibernate.Area;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.AreaRepository;


public class AreaRepositoryMock extends RepositoryMock<Area, AreaRepository>{

    public AreaRepositoryMock(){
        super(AreaRepository.class, AreaMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
