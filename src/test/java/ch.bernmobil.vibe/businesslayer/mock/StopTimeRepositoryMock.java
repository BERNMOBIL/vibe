package ch.bernmobil.vibe.businesslayer.mock;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.StopTimeMockData;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.StopTimeRepository;

public class StopTimeRepositoryMock extends RepositoryMock<StopTime, StopTimeRepository> {

    public StopTimeRepositoryMock() {
        super(StopTimeRepository.class);
    }

    @Override
    protected StopTime getMockObject(int index) {
        return StopTimeMockData.create(index);
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
        when(mock.getNextDeparturesBy(any())).thenReturn(dataSource.subList(0, 2));
    }
}
