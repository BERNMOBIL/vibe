package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.CalendarException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalendarExceptionMockData {
    private static List<CalendarException> dataSource = new ArrayList<>(3);
    private CalendarDateMockData calendarDateMockData;

    @Autowired
    public CalendarExceptionMockData(CalendarDateMockData calendarDateMockData) {
        this.calendarDateMockData = calendarDateMockData;
        IntStream.range(0, idList.length)
            .forEach(i -> dataSource.add(create(i)));
    }

    private UUID[] idList = {
        UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
        UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
        UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private LocalDate[] dateList = {
        LocalDate.of(2017, 4, 1),
        LocalDate.of(2017, 2, 19),
        LocalDate.of(2017, 6, 24)
    };

    private String[] typeList = {
        "ADDED", "ADDED", "REMOVED"
    };

    private CalendarException create(int index) {
        CalendarException c = new CalendarException();
        c.setId(idList[index]);
        c.setDate(dateList[index]);
        c.setType(typeList[index]);
        c.setCalendarDate(calendarDateMockData.get(index));
        return c;
    }

    public CalendarException get(int index) {
        return dataSource.get(index);
    }

    public List<CalendarException> getDataSource() {
        //TODO: check if necessary
        return Collections.unmodifiableList(dataSource);
    }
}
