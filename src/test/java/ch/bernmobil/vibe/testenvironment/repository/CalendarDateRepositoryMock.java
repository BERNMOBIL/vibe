package ch.bernmobil.vibe.testenvironment.repository;

import static org.mockito.Mockito.when;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.CalendarDate;
import ch.bernmobil.vibe.dataaccesslayer.repository.CalendarDateRepository;
import ch.bernmobil.vibe.testenvironment.data.CalendarDateMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalendarDateRepositoryMock extends RepositoryMock<CalendarDate, CalendarDateRepository>{

    @Autowired
    public CalendarDateRepositoryMock(CalendarDateMockData calendarDateMockData){
        super(CalendarDateRepository.class, calendarDateMockData.getDataSource());
    }

    @Override
    protected void configureMock() {
        when(mock.findAll()).thenReturn(dataSource);
    }
}
