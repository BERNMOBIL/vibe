package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.CalendarDateMockData;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarDate;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.repository.CalendarDateRepository;


public class CalendarDateRepositoryMock extends RepositoryMock<CalendarDate, CalendarDateRepository>{

    public CalendarDateRepositoryMock(){
        super(CalendarDateRepository.class, CalendarDateMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
