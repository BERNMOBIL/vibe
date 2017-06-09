package ch.bernmobil.vibe.testenvironment.repository;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.dataaccesslayer.entity.CalendarException;
import ch.bernmobil.vibe.dataaccesslayer.repository.CalendarExceptionRepository;
import ch.bernmobil.vibe.testenvironment.data.CalendarExceptionMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalendarExceptionRepositoryMock extends RepositoryMock<CalendarException, CalendarExceptionRepository>{

    @Autowired
    public CalendarExceptionRepositoryMock(CalendarExceptionMockData calendarExceptionMockData){
        super(CalendarExceptionRepository.class, calendarExceptionMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
