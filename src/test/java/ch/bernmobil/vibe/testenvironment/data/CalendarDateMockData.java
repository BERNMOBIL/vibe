package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.CalendarDate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalendarDateMockData {
    private LocalDateTime update = LocalDateTime.parse("2017-04-29T10:15:30");
    private JourneyMockData journeyMockData;
    private List<CalendarDate> dataSource = new ArrayList<>(3);

    @Autowired
    public CalendarDateMockData(JourneyMockData journeyMockData) {
        this.journeyMockData = journeyMockData;
        IntStream.range(0, idList.length)
            .forEach(i -> dataSource.add(create(i)));
    }

    private UUID[] idList = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private LocalDate[] validFromList = {
        LocalDate.now(),
        LocalDate.now().plusDays(5),
        LocalDate.now().plusDays(5),
    };
    private LocalDate[] validUntilList = {
        LocalDate.now(),
        LocalDate.now().plusDays(5),
        LocalDate.now().plusDays(5),
    };


    private CalendarDate create(int index) {
        CalendarDate d = new CalendarDate();
        d.setId(idList[index]);
        d.setValidFrom(validFromList[index]);
        d.setValidUntil(validUntilList[index]);
        d.setJourney(journeyMockData.get(index));
        d.setUpdateTimestamp(update);
        return d;
    }

    public List<CalendarDate> getDataSource() {
        return dataSource;
    }

    public CalendarDate get(int index) {
        return dataSource.get(index);
    }
}
