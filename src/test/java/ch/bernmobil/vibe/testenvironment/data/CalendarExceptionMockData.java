package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entity.CalendarException;
import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalendarExceptionMockData extends TestData<CalendarException> {
    private final CalendarDateMockData calendarDateMockData;

    private final UUID[] idList = {
        UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
        UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
        UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private final LocalDate[] dateList = {
        LocalDate.of(2017, 4, 1),
        LocalDate.of(2017, 2, 19),
        LocalDate.of(2017, 6, 24)
    };

    private final String[] typeList = {
        "ADDED", "ADDED", "REMOVED"
    };

    @Autowired
    public CalendarExceptionMockData(CalendarDateMockData calendarDateMockData) {
        this.calendarDateMockData = calendarDateMockData;
        dataSource = IntStream.range(0, idList.length)
            .mapToObj(this::create)
            .collect(Collectors.toList());
    }

    private CalendarException create(int index) {
        CalendarException c = new CalendarException();
        c.setId(idList[index]);
        c.setDate(dateList[index]);
        c.setType(typeList[index]);
        c.setCalendarDate(calendarDateMockData.get(index));
        return c;
    }
}
