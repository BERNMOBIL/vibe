package ch.bernmobil.vibe.businesslayer.mock;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.businesslayer.mock.data.CalendarExceptionMockData;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.CalendarException;
import ch.bernmobil.vibe.dataaccesslayer.repository.CalendarExceptionRepository;


public class CalendarExceptionRepositoryMock extends RepositoryMock<CalendarException, CalendarExceptionRepository>{

    public CalendarExceptionRepositoryMock(){
        super(CalendarExceptionRepository.class, CalendarExceptionMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
