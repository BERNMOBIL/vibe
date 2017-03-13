package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.AgencyMockData;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Agency;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.AgencyRepository;


public class AgencyRepositoryMock extends RepositoryMock<Agency, AgencyRepository>{

    public AgencyRepositoryMock(){
        super(AgencyRepository.class);
    }

    @Override
    protected Agency getMockObject(int index) {
        return AgencyMockData.create(index);
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
        when(mock.findFirstByOrderById()).thenReturn(dataSource.get(0));
    }
}
